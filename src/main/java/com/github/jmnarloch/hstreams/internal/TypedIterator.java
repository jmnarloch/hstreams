/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams.internal;

import java.util.Iterator;

/**
 * A strongly typed iterator wrapper.
 *
 * @author Jakub Narloch
 */
class TypedIterator<T> implements Iterator<T> {

    /**
     * The iterator to which all execution is being delegated.
     */
    private Iterator delegate;

    /**
     * Creates new instance of {@link TypedIterator} class.
     *
     * @param delegate the delegate instance
     */
    public TypedIterator(Iterator delegate) {
        this.delegate = delegate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return delegate.hasNext();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        return (T) delegate.next();
    }
}
