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
package com.github.jmnarloch.hstreams;

import org.hibernate.StatelessSessionBuilder;

import java.sql.Connection;

/**
 * A wrapper around the {@link StatelessSessionBuilder} interface that overrides most of the methods return types.
 *
 * @author Jakub Narloch
 */
public interface StreamStatelessSessionBuilder extends StatelessSessionBuilder {

    /**
     * {@inheritDoc}
     */
    @Override
    StreamStatelessSession openStatelessSession();

    /**
     * {@inheritDoc}
     */
    @Override
    StreamStatelessSessionBuilder connection(Connection connection);

    /**
     * {@inheritDoc}
     */
    @Override
    StreamStatelessSessionBuilder tenantIdentifier(String tenantIdentifier);
}
