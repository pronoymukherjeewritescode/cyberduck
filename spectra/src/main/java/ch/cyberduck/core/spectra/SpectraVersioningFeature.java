package ch.cyberduck.core.spectra;

/*
 * Copyright (c) 2002-2018 iterate GmbH. All rights reserved.
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

import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.DefaultIOExceptionMappingService;
import ch.cyberduck.core.PasswordCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.VersioningConfiguration;
import ch.cyberduck.core.cache.LRUCache;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Versioning;
import ch.cyberduck.core.s3.S3PathContainerService;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.UUID;

import com.spectralogic.ds3client.Ds3Client;
import com.spectralogic.ds3client.commands.spectrads3.GetBucketSpectraS3Request;
import com.spectralogic.ds3client.commands.spectrads3.GetBucketSpectraS3Response;
import com.spectralogic.ds3client.commands.spectrads3.GetDataPolicySpectraS3Request;
import com.spectralogic.ds3client.commands.spectrads3.GetDataPolicySpectraS3Response;
import com.spectralogic.ds3client.commands.spectrads3.ModifyDataPolicySpectraS3Request;
import com.spectralogic.ds3client.commands.spectrads3.UndeleteObjectSpectraS3Request;
import com.spectralogic.ds3client.models.VersioningLevel;
import com.spectralogic.ds3client.networking.FailedRequestException;

public class SpectraVersioningFeature implements Versioning {

    private static final Logger log = Logger.getLogger(SpectraVersioningFeature.class);

    public static final String KEY_REVERTABLE
        = "revertable";

    private final SpectraSession session;

    private final PathContainerService containerService
        = new S3PathContainerService();

    private LRUCache<Path, VersioningConfiguration> cache
        = LRUCache.build(10);

    public SpectraVersioningFeature(final SpectraSession session) {
        this.session = session;
    }

    @Override
    public Versioning withCache(final LRUCache<Path, VersioningConfiguration> cache) {
        this.cache = cache;
        return this;
    }

    @Override
    public VersioningConfiguration getConfiguration(final Path file) throws BackgroundException {
        final Ds3Client client = new SpectraClientBuilder().wrap(session.getClient(), session.getHost());
        final Path container = containerService.getContainer(file);
        if(container.isRoot()) {
            return VersioningConfiguration.empty();
        }
        if(cache.contains(container)) {
            return cache.get(container);
        }
        try {
            final GetBucketSpectraS3Response bucket = client.getBucketSpectraS3(new GetBucketSpectraS3Request(container.getName()));
            final GetDataPolicySpectraS3Response policy = client.getDataPolicySpectraS3(
                new GetDataPolicySpectraS3Request(bucket.getBucketResult().getDataPolicyId()));
            final VersioningConfiguration configuration = new VersioningConfiguration(
                policy.getDataPolicyResult().getVersioning() == VersioningLevel.KEEP_MULTIPLE_VERSIONS, false);
            cache.put(container, configuration);
            return configuration;
        }
        catch(FailedRequestException e) {
            throw new SpectraExceptionMappingService().map(e);
        }
        catch(IOException e) {
            throw new DefaultIOExceptionMappingService().map(e);
        }
    }

    @Override
    public void setConfiguration(final Path file, final PasswordCallback prompt, final VersioningConfiguration configuration) throws BackgroundException {
        final Path container = containerService.getContainer(file);
        try {
            final VersioningConfiguration current = this.getConfiguration(container);
            if(configuration.isEnabled()) {
                if(current.isEnabled()) {
                    log.debug(String.format("Versioning already enabled for bucket %s", container));
                }
                else {
                    log.debug(String.format("Enable bucket versioning for %s", container));
                    final Ds3Client client = new SpectraClientBuilder().wrap(session.getClient(), session.getHost());
                    final GetBucketSpectraS3Response bucket = client.getBucketSpectraS3(new GetBucketSpectraS3Request(container.getName()));
                    final UUID id = bucket.getBucketResult().getDataPolicyId();
                    client.modifyDataPolicySpectraS3(new ModifyDataPolicySpectraS3Request(id).withVersioning(VersioningLevel.KEEP_MULTIPLE_VERSIONS));
                }
            }
            else {
                log.warn(String.format("Disable bucket versioning for %s is not supported", container));
            }
            cache.remove(container);
        }
        catch(FailedRequestException e) {
            throw new SpectraExceptionMappingService().map(e);
        }
        catch(IOException e) {
            throw new DefaultIOExceptionMappingService().map(e);
        }
    }

    @Override
    public boolean isRevertable(final Path file) {
        return file.attributes().getCustom().containsKey(KEY_REVERTABLE);
    }

    @Override
    public void revert(final Path file) throws BackgroundException {
        final Ds3Client client = new SpectraClientBuilder().wrap(session.getClient(), session.getHost());
        final Path container = containerService.getContainer(file);
        try {
            client.undeleteObjectSpectraS3(new UndeleteObjectSpectraS3Request(container.getName(), containerService.getKey(file)));
        }
        catch(IOException e) {
            throw new DefaultIOExceptionMappingService().map("Cannot revert file", e, file);
        }
    }

    @Override
    public Credentials getToken(final String mfaSerial, final PasswordCallback callback) {
        return null;
    }
}
