package org.hibernate.streams;

import org.hibernate.SessionFactory;
import org.hibernate.streams.internal.StreamsInternal;

/**
 *
 */
public final class Streams {

    private Streams() {
        // private constructor
    }

    public static StreamSessionFactory wrap(SessionFactory factory) {
        return StreamsInternal.wrap(factory);
    }
}
