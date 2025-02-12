package ch.cyberduck.core.brick;

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

import ch.cyberduck.core.AbstractHostCollection;
import ch.cyberduck.core.BookmarkCollection;
import ch.cyberduck.core.HostPasswordStore;
import ch.cyberduck.core.LoginCallback;
import ch.cyberduck.core.PasswordStoreFactory;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.ConnectionCanceledException;
import ch.cyberduck.core.http.DisabledServiceUnavailableRetryStrategy;
import ch.cyberduck.core.proxy.ProxyFactory;
import ch.cyberduck.core.proxy.ProxyHostUrlProvider;
import ch.cyberduck.core.threading.BackgroundAction;
import ch.cyberduck.core.threading.BackgroundActionRegistry;
import ch.cyberduck.core.threading.BackgroundActionStateCancelCallback;
import ch.cyberduck.core.threading.CancelCallback;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HttpContext;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;

public class BrickUnauthorizedRetryStrategy extends DisabledServiceUnavailableRetryStrategy {
    private static final Logger log = Logger.getLogger(BrickUnauthorizedRetryStrategy.class);

    private static final int MAX_RETRIES = 1;

    private final Semaphore semaphore = new Semaphore(1);
    private final HostPasswordStore store = PasswordStoreFactory.get();
    private final BrickSession session;
    private final LoginCallback prompt;
    private final CancelCallback cancel;

    public BrickUnauthorizedRetryStrategy(final BrickSession session, final LoginCallback prompt, final CancelCallback cancel) {
        this.session = session;
        this.prompt = prompt;
        this.cancel = cancel;
    }

    @Override
    public boolean retryRequest(final HttpResponse response, final int executionCount, final HttpContext context) {
        switch(response.getStatusLine().getStatusCode()) {
            case HttpStatus.SC_UNAUTHORIZED:
                if(executionCount <= MAX_RETRIES) {
                    if(log.isDebugEnabled()) {
                        log.debug(String.format("Try to acquire semaphore for %s", session));
                    }
                    // Pairing token no longer valid
                    if(!semaphore.tryAcquire()) {
                        log.warn(String.format("Skip pairing because semaphore cannot be aquired for %s", session));
                        return false;
                    }
                    try {
                        log.warn(String.format("Run pairing flow for %s", session));
                        // Blocks until pairing is complete or canceled
                        session.login(ProxyFactory.get().find(new ProxyHostUrlProvider().get(session.getHost())),
                            prompt, new BackgroundActionRegistryCancelCallback(cancel));
                        if(session.getHost().getCredentials().isSaved()) {
                            store.save(session.getHost());
                        }
                        // Notify changed bookmark
                        final AbstractHostCollection bookmarks = BookmarkCollection.defaultCollection();
                        if(bookmarks.isLoaded()) {
                            if(bookmarks.contains(session.getHost())) {
                                bookmarks.collectionItemChanged(session.getHost());
                            }
                        }
                        return true;
                    }
                    catch(BackgroundException e) {
                        log.warn(String.format("Failure %s trying to refresh pairing after error response %s", e, response));
                    }
                    finally {
                        if(log.isDebugEnabled()) {
                            log.debug(String.format("Release semaphore for %s", session));
                        }
                        semaphore.release();
                    }
                }
        }
        return false;
    }

    private static final class BackgroundActionRegistryCancelCallback implements CancelCallback {
        private final CancelCallback delegate;

        public BackgroundActionRegistryCancelCallback(final CancelCallback delegate) {
            this.delegate = delegate;
        }

        @Override
        public void verify() throws ConnectionCanceledException {
            delegate.verify();
            for(BackgroundAction action : BackgroundActionRegistry.global()) {
                if(null == action) {
                    continue;
                }
                // Fail if any current background action is canceled
                new BackgroundActionStateCancelCallback(action).verify();
            }
        }
    }
}
