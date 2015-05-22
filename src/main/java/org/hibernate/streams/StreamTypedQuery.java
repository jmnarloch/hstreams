package org.hibernate.streams;

/**
 * A strongly typed query.
 *
 * @param <E> the entity type
 * @author Jakub Narloch
 */
public interface StreamTypedQuery<E> extends StreamQuery<StreamTypedQuery<E>>, BaseStreamTypedQuery<E> {


}
