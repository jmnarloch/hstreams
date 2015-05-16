package org.hibernate.streams.internal;

import org.hibernate.SessionFactory;
import org.hibernate.streams.StreamSessionFactory;

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
