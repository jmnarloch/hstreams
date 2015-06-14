/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
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
