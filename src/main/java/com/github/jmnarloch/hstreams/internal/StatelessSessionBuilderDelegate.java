/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams.internal;

import com.github.jmnarloch.hstreams.StreamStatelessSession;
import com.github.jmnarloch.hstreams.StreamStatelessSessionBuilder;
import org.hibernate.StatelessSessionBuilder;

import java.sql.Connection;

/**
 * The {@link StatelessSessionBuilder} decorator.
 *
 * @author Jakub Narloch
 */
class StatelessSessionBuilderDelegate implements StreamStatelessSessionBuilder {

    private final StatelessSessionBuilder delegate;

    StatelessSessionBuilderDelegate(StatelessSessionBuilder delegate) {
        this.delegate = delegate;
    }

    @Override
    public StreamStatelessSession openStatelessSession() {
        return new StatelessSessionDelegate(delegate.openStatelessSession());
    }

    @Override
    public StreamStatelessSessionBuilder connection(Connection connection) {
        return wrap(delegate.connection(connection));
    }

    @Override
    public StreamStatelessSessionBuilder tenantIdentifier(String tenantIdentifier) {
        return wrap(delegate.tenantIdentifier(tenantIdentifier));
    }

    private StreamStatelessSessionBuilder wrap(StatelessSessionBuilder statelessSessionBuilder) {
        return this;
    }
}
