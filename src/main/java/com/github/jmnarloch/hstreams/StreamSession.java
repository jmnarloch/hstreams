package com.github.jmnarloch.hstreams;

import org.hibernate.LockOptions;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Optional;

/**
 * A wrapper around the {@link Session} interface that overrides most of the methods return types.
 *
 * @author Jakub Narloch
 */
public interface StreamSession extends BaseStreamSession, Session {

    /**
     * {@inheritDoc}
     */
    @Override
    StreamSessionFactory getSessionFactory();

    /**
     * Returns the persistent instance of the given entity class that matches the given identifier,
     * the value is  wrapped into {@link Optional}. (If the instance is already associated with
     * the session, return that instance. This method never returns an uninitialized instance.)
     * Obtains the specified lock mode if the instance exists.
     *
     * @param clazz       a persistent type
     * @param id          an identifier
     * @param lockOptions the lock mode
     * @return an optional persistence instance
     */
    Optional<?> getOptional(Class clazz, Serializable id, LockOptions lockOptions);

    /**
     * Return the persistent instance of the given named entity that matches the given identifier,
     * the value is  wrapped into {@link Optional}. (If the instance is already associated with
     * the session, return that instance. This method never returns an uninitialized instance.)
     * Obtains the specified lock mode if the instance exists.
     *
     * @param entityName  the entity name
     * @param id          an identifier
     * @param lockOptions the lock mode
     * @return an optional persistence instance
     */
    Optional<?> getOptional(String entityName, Serializable id, LockOptions lockOptions);
}
