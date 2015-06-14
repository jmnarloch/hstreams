/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams;

import org.hibernate.LockMode;
import org.hibernate.StatelessSession;

import java.io.Serializable;
import java.util.Optional;

/**
 * A wrapper around the {@link StatelessSession} interface that overrides most of the methods return types.
 *
 * @author Jakub Narloch
 */
public interface StreamStatelessSession extends BaseStreamSession, StatelessSession {

    /**
     * Returns the persistent instance of the given entity class that matches the given identifier,
     * the value is  wrapped into {@link Optional}. (If the instance is already associated with
     * the session, return that instance. This method never returns an uninitialized instance.)
     * Obtains the specified lock mode if the instance exists.
     *
     * @param clazz    a persistent type
     * @param id       an identifier
     * @param lockMode the lock mode
     * @return an optional persistence instance
     */
    <T> Optional<T> getOptional(Class<T> clazz, Serializable id, LockMode lockMode);

    /**
     * Return the persistent instance of the given named entity that matches the given identifier,
     * the value is  wrapped into {@link Optional}. (If the instance is already associated with
     * the session, return that instance. This method never returns an uninitialized instance.)
     * Obtains the specified lock mode if the instance exists.
     *
     * @param entityName the entity name
     * @param id         an identifier
     * @param lockMode   the lock mode
     * @return an optional persistence instance
     */
    <T> Optional<T> getOptional(String entityName, Serializable id, LockMode lockMode);
}
