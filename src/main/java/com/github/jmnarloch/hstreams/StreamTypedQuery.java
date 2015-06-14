/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams;

/**
 * A strongly typed query.
 *
 * @param <E> the entity type
 * @author Jakub Narloch
 */
public interface StreamTypedQuery<E> extends StreamQuery<StreamTypedQuery<E>>, BaseStreamTypedQuery<E> {


}
