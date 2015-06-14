/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams.internal;

import com.github.jmnarloch.hstreams.StreamSessionFactory;
import org.hibernate.SessionFactory;

/**
 * The internal wrapper implementation that hides any implementation details.
 *
 * @author Jakub Narloch
 */
public final class StreamsInternal {

    /**
     * Creates new instance of {@link StreamsInternal}.
     * <p>
     * Private constructor prevents from instantiation outside this class.
     */
    private StreamsInternal() {
        // private constructor
    }

    /**
     * Wraps the passed {@link SessionFactory}.
     *
     * @param factory the session factory
     * @return the decorator around the session factory
     */
    public static StreamSessionFactory wrap(SessionFactory factory) {
        return new SessionFactoryDelegate(factory);
    }
}
