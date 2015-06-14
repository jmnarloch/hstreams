/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.Interceptor;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionEventListener;

import java.sql.Connection;

/**
 * A wrapper around the {@link SessionBuilder} interface that overrides most of the methods return types.
 *
 * @author Jakub Narloch
 */
public interface StreamSessionBuilder extends SessionBuilder {

    @Override
    StreamSession openSession();

    @Override
    StreamSessionBuilder interceptor(Interceptor interceptor);

    @Override
    StreamSessionBuilder noInterceptor();

    @Override
    StreamSessionBuilder connection(Connection connection);

    @Override
    StreamSessionBuilder connectionReleaseMode(ConnectionReleaseMode connectionReleaseMode);

    @Override
    StreamSessionBuilder autoJoinTransactions(boolean autoJoinTransactions);

    @Override
    StreamSessionBuilder autoClose(boolean autoClose);

    @Override
    StreamSessionBuilder flushBeforeCompletion(boolean flushBeforeCompletion);

    @Override
    StreamSessionBuilder tenantIdentifier(String tenantIdentifier);

    @Override
    StreamSessionBuilder eventListeners(SessionEventListener... listeners);

    @Override
    StreamSessionBuilder clearEventListeners();
}
