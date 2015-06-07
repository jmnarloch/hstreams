package com.github.jmnarloch.hstreams;

/**
 * The strongly typed SQL query.
 *
 * @param <E> the entity type
 * @author Jakub Narloch
 */
public interface StreamTypedSQLQuery<E> extends StreamSQLQuery<StreamTypedSQLQuery<E>>, BaseStreamTypedQuery<E> {

}
