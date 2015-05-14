package org.hibernate.streams;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.sql.Connection;

/**
 *
 */
public interface StreamSessionFactory extends SessionFactory {

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
