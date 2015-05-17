package org.hibernate.streams;

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
