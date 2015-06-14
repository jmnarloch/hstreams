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
