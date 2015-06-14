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

import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.type.Type;

/**
 * The base class for the all the query delegates.
 *
 * @author Jakub Narloch
 */
abstract class BaseQueryDelegate<T extends Query> {

    /**
     * The delegated instance, to which all execution is being passed.
     */
    private final T delegate;

    /**
     * Creates new instance of {@link BaseQueryDelegate} class.
     *
     * @param delegate
     */
    BaseQueryDelegate(T delegate) {
        this.delegate = delegate;
    }

    /**
     * Retrieves the delegate instance.
     *
     * @return the delegate instance
     */
    protected T delegate() {
        return delegate;
    }

    public FlushMode getFlushMode() {
        return delegate.getFlushMode();
    }

    public CacheMode getCacheMode() {
        return delegate.getCacheMode();
    }

    public boolean isCacheable() {
        return delegate.isCacheable();
    }

    public String getCacheRegion() {
        return delegate.getCacheRegion();
    }

    public Integer getTimeout() {
        return delegate.getTimeout();
    }

    public Integer getFetchSize() {
        return delegate.getFetchSize();
    }

    public boolean isReadOnly() {
        return delegate.isReadOnly();
    }

    public Type[] getReturnTypes() {
        return delegate.getReturnTypes();
    }
}
