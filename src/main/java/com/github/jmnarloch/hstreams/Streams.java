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
package com.github.jmnarloch.hstreams;

import com.github.jmnarloch.hstreams.internal.StreamsInternal;
import org.hibernate.SessionFactory;

/**
 * An convenient utility class that allows to wrap the standard Hibernate {@link SessionFactory}.
 *
 * @author Jakub Narloch
 */
public final class Streams {

    /**
     * Creates new instance of {@link Streams}.
     * <p>
     * Private constructor prevents from instantiation outside this class.
     */
    private Streams() {
        // private constructor
    }

    /**
     * Wraps the passed {@link SessionFactory} instance into a decorator interface that extends the base
     * query interface.
     *
     * @param factory the session factory
     * @return the decorator around the session factory
     */
    public static StreamSessionFactory wrap(SessionFactory factory) {
        return StreamsInternal.wrap(factory);
    }
}
