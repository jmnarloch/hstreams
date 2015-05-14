package org.hibernate.streams.internal;

import org.hibernate.SessionFactory;
import org.hibernate.streams.StreamSessionFactory;

/**
 *
 */
public final class StreamsInternal {

    private StreamsInternal() {
        // private constructor
    }

    public static StreamSessionFactory wrap(SessionFactory factory) {
        return new SessionFactoryDelegate(factory);
    }
}
