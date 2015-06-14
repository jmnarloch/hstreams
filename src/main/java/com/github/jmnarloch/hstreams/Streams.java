/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
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
