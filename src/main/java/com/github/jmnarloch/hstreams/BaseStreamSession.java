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

import java.io.Serializable;
import java.util.Optional;

/**
 * The base class for all stream sessions.
 *
 * @author Jakub Narloch
 */
public interface BaseStreamSession {

    /**
     * {@inheritDoc}
     */
    StreamQuery getNamedQuery(String queryName);

    /**
     * {@inheritDoc}
     */
    StreamQuery createQuery(String queryString);

    /**
     * Creates strongly typed query that is bounded to the passed type.
     *
     * @param queryString the query string
     * @param clazz       the entity class
     * @param <T>         the entity type
     * @return the query instance
     */
    <T> StreamTypedQuery<T> createTypedQuery(String queryString, Class<T> clazz);

    /**
     * Retrieves the defined query by it's name.
     *
     * @param queryName the query name
     * @param clazz     the entity class
     * @param <T>       the entity type
     * @return the query instance
     */
    <T> StreamTypedQuery<T> getTypedNamedQuery(String queryName, Class<T> clazz);

    /**
     * {@inheritDoc}
     */
    StreamSQLQuery createSQLQuery(String queryString);

    /**
     * Creates strongly typed query that is bounded to the passed type.
     *
     * @param queryString the query string
     * @param clazz       the entity class
     * @param <T>         the entity type
     * @return the query instance
     */
    <T> StreamTypedSQLQuery<T> createTypedSQLQuery(String queryString, Class<T> clazz);

    /**
     * Returns the persistent instance of the given entity class that matches the given identifier,
     * the value is  wrapped into {@link Optional}. (If the instance is already associated with
     * the session, return that instance. This method never returns an uninitialized instance.)
     *
     * @param clazz a persistent type
     * @param id    an identifier
     * @param <T>   the entity type
     * @return an optional persistence instance
     */
    <T> Optional<T> getOptional(Class<T> clazz, Serializable id);

    /**
     * Return the persistent instance of the given named entity that matches the given identifier,
     * the value is  wrapped into {@link Optional}. (If the instance is already associated with
     * the session, return that instance. This method never returns an uninitialized instance.)
     *
     * @param entityName the entity name
     * @param id         an identifier
     * @param <T>        the entity type
     * @return an optional persistence instance
     */
    <T> Optional<T> getOptional(String entityName, Serializable id);
}
