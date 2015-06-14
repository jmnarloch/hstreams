/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
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
     * @param <T>         the entity type
     * @return an optional persistence instance
     */
    <T> Optional<T> getOptional(Class<T> clazz, Serializable id, LockOptions lockOptions);

    /**
     * Return the persistent instance of the given named entity that matches the given identifier,
     * the value is  wrapped into {@link Optional}. (If the instance is already associated with
     * the session, return that instance. This method never returns an uninitialized instance.)
     * Obtains the specified lock mode if the instance exists.
     *
     * @param entityName  the entity name
     * @param id          an identifier
     * @param lockOptions the lock mode
     * @param <T>         the entity type
     * @return an optional persistence instance
     */
    <T> Optional<T> getOptional(String entityName, Serializable id, LockOptions lockOptions);
}
