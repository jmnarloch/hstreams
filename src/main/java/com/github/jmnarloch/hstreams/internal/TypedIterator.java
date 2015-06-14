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
