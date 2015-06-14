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

import org.hibernate.NonUniqueResultException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The base extended Query interface that adds Java 8 specific methods, allowing to
 * treat the query result as a {@link Stream} or retrieve {@link Optional} wrapped entities.
 *
 * @param <T> the concrete query type
 * @author Jakub Narloch
 */
public interface BaseStreamQuery<T extends BaseStreamQuery<T>> {

    /**
     * Returns the query result as a {@link java.util.stream.Stream}.
     * The stream operates on the loaded data, so each individual record
     * will be loaded into memory as a result of invoking this method.
     *
     * @return the result stream
     */
    Stream<?> stream();

    /**
     * Returns the query result as a {@link Stream}.
     * The stream operates on the loaded data, so each individual record
     * will be loaded into memory as a result of invoking this method.
     *
     * @return the result stream
     */
    Stream<?> parallelStream();

    /**
     * Returns a single optional instance that matches the query, if non element
     * matches the query the optional result will not be present - {@link Optional#isPresent()}
     * returning {@code false}.
     *
     * @return the single optional result
     * @throws NonUniqueResultException if there is more than one matching result
     */
    Optional<?> optionalResult();

    /**
     * Sets a positional {@link LocalDate} parameter using just date portion.
     *
     * @param position  the parameter position
     * @param localDate the date value
     * @return the reference to {@code this}
     */
    T setLocalDate(int position, LocalDate localDate);

    /**
     * Sets a named {@link LocalDate} parameter using just date portion.
     *
     * @param name      the parameter name
     * @param localDate the date value
     * @return the reference to {@code this}
     */
    T setLocalDate(String name, LocalDate localDate);

    /**
     * Sets a positional {@link LocalTime} parameter using just time portion.
     *
     * @param position  the parameter position
     * @param localTime the time value
     * @return the reference to {@code this}
     */
    T setLocalTime(int position, LocalTime localTime);

    /**
     * Sets a named {@link LocalTime} parameter using just time portion.
     *
     * @param name      the parameter name
     * @param localTime the time value
     * @return the reference to {@code this}
     */
    T setLocalTime(String name, LocalTime localTime);
}
