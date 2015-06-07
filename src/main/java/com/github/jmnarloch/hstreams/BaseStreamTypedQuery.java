package com.github.jmnarloch.hstreams;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The base contract for all strongly typed queries.
 *
 * @param <E> the entity type
 * @author Jakub Narloch
 */
public interface BaseStreamTypedQuery<E> {

    /**
     * {@inheritDoc}
     */
    List<E> list();

    /**
     * {@inheritDoc}
     */
    E uniqueResult();

    /**
     * {@inheritDoc}
     */
    Iterator<E> iterate();

    /**
     * {@inheritDoc}
     */
    Stream<E> stream();

    /**
     * {@inheritDoc}
     */
    Stream<E> parallelStream();

    /**
     * {@inheritDoc}
     */
    Optional<E> optionalResult();
}
