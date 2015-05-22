package org.hibernate.streams;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The base extended Query interface that adds Java 8 specific methods, allowing to
 * treat the query result as a {@link Stream} or retrieve {@link Optional} wrapped entities.
 *
 * @param <T> the concreate query type
 *
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

    T setLocalDate(int position, LocalDate localDate);

    T setLocalDate(String name, LocalDate localDate);

    T setLocalTime(int position, LocalTime localTime);

    T setLocalTime(String name, LocalTime localTime);
}
