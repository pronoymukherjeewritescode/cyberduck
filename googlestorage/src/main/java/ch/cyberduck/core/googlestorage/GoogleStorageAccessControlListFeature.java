package ch.cyberduck.core.googlestorage;

/*
 * Copyright (c) 2002-2020 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.Acl;
import ch.cyberduck.core.LocaleFactory;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.InteroperabilityException;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.features.AclPermission;
import ch.cyberduck.core.shared.DefaultAclFeature;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.BucketAccessControls;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.ObjectAccessControls;

public class GoogleStorageAccessControlListFeature extends DefaultAclFeature implements AclPermission {
    private static final Logger log = Logger.getLogger(GoogleStorageAccessControlListFeature.class);

    private final PathContainerService containerService
        = new GoogleStoragePathContainerService();

    private final GoogleStorageSession session;

    public GoogleStorageAccessControlListFeature(final GoogleStorageSession session) {
        this.session = session;
    }

    @Override
    public Acl getPermission(final Path file) throws BackgroundException {
        try {
            final Acl acl = new Acl();
            if(containerService.isContainer(file)) {
                final BucketAccessControls controls = session.getClient().bucketAccessControls().list(
                    containerService.getContainer(file).getName()).execute();
                for(BucketAccessControl control : controls.getItems()) {
                    final String entity = control.getEntity();
                    acl.addAll(this.toUser(entity, control.getEmail()), new Acl.Role(control.getRole()));
                }
            }
            else {
                final ObjectAccessControls controls = session.getClient().objectAccessControls().list(containerService.getContainer(file).getName(), containerService.getKey(file)).execute();
                for(ObjectAccessControl control : controls.getItems()) {
                    final String entity = control.getEntity();
                    acl.addAll(this.toUser(entity, control.getEmail()), this.toRole(control));
                }
            }
            return acl;
        }
        catch(IOException e) {
            final BackgroundException failure = new GoogleStorageExceptionMappingService().map("Failure to read attributes of {0}", e, file);
            if(file.isPlaceholder()) {
                if(failure instanceof NotfoundException) {
                    // No placeholder file may exist but we just have a common prefix
                    return Acl.EMPTY;
                }
            }
            if(failure instanceof InteroperabilityException) {
                // The specified method is not allowed against this resource. The case for delete markers in versioned buckets.
                return Acl.EMPTY;
            }
            throw failure;
        }
    }

    protected Acl.User toUser(final String entity, final String email) {
        if(entity.startsWith("user-")) {
            if(StringUtils.isNotBlank(email)) {
                return new Acl.EmailUser(StringUtils.substringAfter(entity, "user-"));
            }
        }
        else if(entity.startsWith("group-")) {
            if(StringUtils.isNotBlank(email)) {
                return new Acl.EmailGroupUser(StringUtils.substringAfter(entity, "group-"));
            }
            else {
                return new Acl.GroupUser(StringUtils.substringAfter(entity, "group-"));
            }
        }
        else if(entity.startsWith("domain-")) {
            return new Acl.DomainUser(StringUtils.substringAfter(entity, "domain-"));
        }
        switch(entity) {
            case "allUsers":
                return new Acl.GroupUser(Acl.GroupUser.EVERYONE, false);
            case "allAuthenticatedUsers":
                return new Acl.GroupUser(Acl.GroupUser.AUTHENTICATED, false);
        }
        return new Acl.CanonicalUser(entity);
    }

    protected Acl.Role toRole(final ObjectAccessControl control) {
        switch(control.getRole()) {
            // Caveat that this API uses READER and OWNER instead of READ and FULL_CONTROL.
            case "READER":
                return new Acl.Role(Acl.Role.READ);
            case "OWNER":
                return new Acl.Role(Acl.Role.FULL);
        }
        return new Acl.Role(control.getRole());
    }

    @Override
    public void setPermission(final Path file, final Acl acl) throws BackgroundException {
        try {
            if(containerService.isContainer(file)) {
                final List<BucketAccessControl> bucketAccessControls = this.toBucketAccessControl(acl);
                for(BucketAccessControl control : bucketAccessControls) {
                    session.getClient().bucketAccessControls().patch(containerService.getContainer(file).getName(),
                        control.getEntity(), control).execute();
                }
            }
            else {
                final List<ObjectAccessControl> objectAccessControls = this.toObjectAccessControl(acl);
                for(ObjectAccessControl control : objectAccessControls) {
                    session.getClient().objectAccessControls().patch(containerService.getContainer(file).getName(), containerService.getKey(file),
                        control.getEntity(), control).execute();
                }
            }
        }
        catch(IOException e) {
            final BackgroundException failure = new GoogleStorageExceptionMappingService().map("Cannot change permissions of {0}", e, file);
            if(file.isPlaceholder()) {
                if(failure instanceof NotfoundException) {
                    // No placeholder file may exist but we just have a common prefix
                    return;
                }
            }
            // 400 Bad Request response for buckets with uniform bucket-level access enabled
            throw failure;
        }
    }

    protected List<BucketAccessControl> toBucketAccessControl(final Acl acl) {
        final List<BucketAccessControl> list = new ArrayList<>();
        for(Acl.UserAndRole userAndRole : acl.asList()) {
            if(!userAndRole.isValid()) {
                continue;
            }
            final BucketAccessControl control = new BucketAccessControl();
            control.setRole(userAndRole.getRole().getName());
            if(userAndRole.getUser() instanceof Acl.EmailUser) {
                control.setEntity(String.format("user-%s", userAndRole.getUser().getIdentifier()));
                control.setEmail(userAndRole.getUser().getIdentifier());
            }
            else if(userAndRole.getUser() instanceof Acl.GroupUser) {
                if(userAndRole.getUser().getIdentifier().equals(Acl.GroupUser.EVERYONE)) {
                    // This special scope identifier represents anyone who is on the Internet, with or without a Google
                    // account. The special scope identifier for all users is AllUsers.
                    control.setEntity("allUsers");
                }
                else if(userAndRole.getUser().getIdentifier().equals(Acl.GroupUser.AUTHENTICATED)) {
                    // This special scope identifier represents anyone who is authenticated with a Google account. The special scope identifier
                    // for all Google account holders is AllAuthenticatedUsers.
                    control.setEntity("allAuthenticatedUsers");
                }
                else {
                    control.setEntity(String.format("group-%s", userAndRole.getUser().getIdentifier()));
                }
            }
            else if(userAndRole.getUser() instanceof Acl.DomainUser) {
                control.setEntity(String.format("domain-%s", userAndRole.getUser().getIdentifier()));
                control.setDomain(userAndRole.getUser().getIdentifier());
            }
            if(userAndRole.getUser() instanceof Acl.CanonicalUser) {
                control.setEntity(userAndRole.getUser().getIdentifier());
                control.setEmail(userAndRole.getUser().getIdentifier());
            }
            else if(userAndRole.getUser() instanceof Acl.EmailGroupUser) {
                control.setEntity(String.format("group-%s", userAndRole.getUser().getIdentifier()));
                control.setEmail(userAndRole.getUser().getIdentifier());
            }
            else {
                log.warn(String.format("Unsupported user %s", userAndRole.getUser()));
            }
            list.add(control);
        }
        return list;
    }

    protected List<ObjectAccessControl> toObjectAccessControl(final Acl acl) {
        final List<ObjectAccessControl> list = new ArrayList<>();
        // Do not set owner for ACL which is set automatically
        for(Acl.UserAndRole userAndRole : acl.asList()) {
            if(!userAndRole.isValid()) {
                continue;
            }
            final ObjectAccessControl control = new ObjectAccessControl();
            switch(userAndRole.getRole().getName()) {
                // Caveat that this API uses READER and OWNER instead of READ and FULL_CONTROL.
                case Acl.Role.READ:
                    control.setRole("READER");
                    break;
                case Acl.Role.FULL:
                    control.setRole("OWNER");
                    break;
            }
            if(userAndRole.getUser() instanceof Acl.EmailUser) {
                control.setEntity(String.format("user-%s", userAndRole.getUser().getIdentifier()));
                control.setEmail(userAndRole.getUser().getIdentifier());
            }
            else if(userAndRole.getUser() instanceof Acl.GroupUser) {
                if(userAndRole.getUser().getIdentifier().equals(Acl.GroupUser.EVERYONE)) {
                    // This special scope identifier represents anyone who is on the Internet, with or without a Google
                    // account. The special scope identifier for all users is AllUsers.
                    control.setEntity("allUsers");
                }
                else if(userAndRole.getUser().getIdentifier().equals(Acl.GroupUser.AUTHENTICATED)) {
                    // This special scope identifier represents anyone who is authenticated with a Google account. The special scope identifier
                    // for all Google account holders is AllAuthenticatedUsers.
                    control.setEntity("allAuthenticatedUsers");
                }
                else {
                    control.setEntity(String.format("group-%s", userAndRole.getUser().getIdentifier()));
                }
            }
            else if(userAndRole.getUser() instanceof Acl.DomainUser) {
                control.setEntity(String.format("domain-%s", userAndRole.getUser().getIdentifier()));
                control.setDomain(userAndRole.getUser().getIdentifier());
            }
            else if(userAndRole.getUser() instanceof Acl.CanonicalUser) {
                control.setEntity(userAndRole.getUser().getIdentifier());
                control.setEmail(userAndRole.getUser().getIdentifier());
            }
            else if(userAndRole.getUser() instanceof Acl.EmailGroupUser) {
                control.setEntity(String.format("group-%s", userAndRole.getUser().getIdentifier()));
                control.setEmail(userAndRole.getUser().getIdentifier());
            }
            else {
                log.warn(String.format("Unsupported user %s", userAndRole.getUser()));
            }
            list.add(control);
        }
        return list;
    }

    @Override
    public List<Acl.User> getAvailableAclUsers() {
        final List<Acl.User> users = new ArrayList<Acl.User>(Arrays.asList(
            new Acl.CanonicalUser(),
            new Acl.GroupUser(Acl.GroupUser.AUTHENTICATED, false),
            new Acl.GroupUser(Acl.GroupUser.EVERYONE, false))
        );
        users.add(new Acl.EmailUser() {
            @Override
            public String getPlaceholder() {
                return LocaleFactory.localizedString("Google Account Email Address", "S3");
            }
        });
        // Google Apps customers can associate their email accounts with an Internet domain name. When you do
        // this, each email account takes the form username@yourdomain.com. You can specify a scope by using
        // any Internet domain name that is associated with a Google Apps account.
        users.add(new Acl.DomainUser(StringUtils.EMPTY) {
            @Override
            public String getPlaceholder() {
                return LocaleFactory.localizedString("Google Apps Domain", "S3");
            }
        });
        users.add(new Acl.EmailGroupUser(StringUtils.EMPTY, true) {
            @Override
            public String getPlaceholder() {
                return LocaleFactory.localizedString("Google Group Email Address", "S3");
            }
        });
        return users;
    }

    @Override
    public List<Acl.Role> getAvailableAclRoles(final List<Path> files) {
        // There are two roles that can be assigned to an entity:
        return new ArrayList<Acl.Role>(Arrays.asList(
            new Acl.Role(Acl.Role.FULL),
            new Acl.Role(Acl.Role.READ))
        );
    }
}
