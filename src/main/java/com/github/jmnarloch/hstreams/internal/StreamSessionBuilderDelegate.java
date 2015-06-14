/**
 * Copyright (c) 2015 HStreams contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jmnarloch.hstreams.internal;

import com.github.jmnarloch.hstreams.StreamSession;
import com.github.jmnarloch.hstreams.StreamSessionBuilder;
import org.hibernate.ConnectionReleaseMode;
import org.hibernate.Interceptor;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionEventListener;

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
