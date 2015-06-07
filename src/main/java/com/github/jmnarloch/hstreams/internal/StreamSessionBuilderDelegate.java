package com.github.jmnarloch.hstreams.internal;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.Interceptor;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionEventListener;
import com.github.jmnarloch.hstreams.StreamSession;
import com.github.jmnarloch.hstreams.StreamSessionBuilder;

import java.sql.Connection;

/**
 * The {@link SessionBuilder} decorator.
 *
 * @author Jakub Narloch
 */
class StreamSessionBuilderDelegate implements StreamSessionBuilder {

    private final SessionBuilder delegate;

    StreamSessionBuilderDelegate(SessionBuilder delegate) {
        this.delegate = delegate;
    }

    @Override
    public StreamSession openSession() {
        return new SessionDelegate(delegate.openSession());
    }

    @Override
    public StreamSessionBuilder interceptor(Interceptor interceptor) {
        return wrap(delegate.interceptor(interceptor));
    }

    @Override
    public StreamSessionBuilder noInterceptor() {
        return wrap(delegate.noInterceptor());
    }

    @Override
    public StreamSessionBuilder connection(Connection connection) {
        return wrap(delegate.connection(connection));
    }

    @Override
    public StreamSessionBuilder connectionReleaseMode(ConnectionReleaseMode connectionReleaseMode) {
        return wrap(delegate.connectionReleaseMode(connectionReleaseMode));
    }

    @Override
    public StreamSessionBuilder autoJoinTransactions(boolean autoJoinTransactions) {
        return wrap(delegate.autoJoinTransactions(autoJoinTransactions));
    }

    @Override
    public StreamSessionBuilder autoClose(boolean autoClose) {
        return wrap(delegate.autoClose(autoClose));
    }

    @Override
    public StreamSessionBuilder flushBeforeCompletion(boolean flushBeforeCompletion) {
        return wrap(delegate.flushBeforeCompletion(flushBeforeCompletion));
    }

    @Override
    public StreamSessionBuilder tenantIdentifier(String tenantIdentifier) {
        return wrap(delegate.tenantIdentifier(tenantIdentifier));
    }

    @Override
    public StreamSessionBuilder eventListeners(SessionEventListener... listeners) {
        return wrap(delegate.eventListeners(listeners));
    }

    @Override
    public StreamSessionBuilder clearEventListeners() {
        return wrap(delegate.clearEventListeners());
    }

    private StreamSessionBuilder wrap(SessionBuilder sessionBuilder) {
        return this;
    }
}
