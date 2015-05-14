package org.hibernate.streams;

import org.hibernate.SessionFactory;
import org.hibernate.streams.model.User;

import java.util.Optional;

/**
 *
 */
public class Demo {

    public void demo() {

        SessionFactory originalFactory = null;

        StreamSessionFactory factory = Streams.wrap(originalFactory);
        StreamSession session = factory.getCurrentSession();

        long count = session.createQuery("from User")
                .stream()
                .count();

        Optional<?> admin = session.createQuery("from User where id = :id")
                .setParameter("id", 1l)
                .optionalResult();

        Optional<?> user = session.getOptional("User", 1l);
    }
}