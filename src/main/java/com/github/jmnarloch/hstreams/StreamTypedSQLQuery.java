/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams;

/**
 * The strongly typed SQL query.
 *
 * @param <E> the entity type
 * @author Jakub Narloch
 */
public interface StreamTypedSQLQuery<E> extends StreamSQLQuery<StreamTypedSQLQuery<E>>, BaseStreamTypedQuery<E> {

}
