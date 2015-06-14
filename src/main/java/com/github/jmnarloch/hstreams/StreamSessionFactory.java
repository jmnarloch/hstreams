/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.sql.Connection;

/**
 * A wrapper around the {@link SessionFactory} interface that overrides most of the methods return types.
 *
 * @author Jakub Narloch
 */
public interface StreamSessionFactory extends SessionFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    StreamSessionBuilder withOptions();

    /**
     * {@inheritDoc}
     */
    @Override
    StreamStatelessSessionBuilder withStatelessOptions();

    /**
     * {@inheritDoc}
     */
    @Override
    StreamSession openSession() throws HibernateException;

    /**
     * {@inheritDoc}
     */
    @Override
    StreamSession getCurrentSession() throws HibernateException;

    /**
     * {@inheritDoc}
     */
    @Override
    StreamStatelessSession openStatelessSession();

    /**
     * {@inheritDoc}
     */
    @Override
    StreamStatelessSession openStatelessSession(Connection connection);
}
