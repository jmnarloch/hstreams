package org.hibernate.streams;

/**
 * The strongly typed SQL query.
 *
 * @param <E> the entity type
 * @author Jakub Narloch
 */
public interface StreamTypedSQLQuery<E> extends StreamSQLQuery<StreamTypedSQLQuery<E>>, BaseStreamTypedQuery<E> {

}
