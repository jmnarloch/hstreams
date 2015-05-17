package org.hibernate.streams.internal;

import org.hibernate.StatelessSessionBuilder;
import org.hibernate.streams.StreamStatelessSession;
import org.hibernate.streams.StreamStatelessSessionBuilder;

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
