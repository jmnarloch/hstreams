/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams;

import com.github.jmnarloch.hstreams.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Demonstrates the usage of this component.
 *
 * @author Jakub Narloch
 */
public class Demo {

    /**
     * The API usage demo.
     */
    @Test
    public void demo() {

        SessionFactory originalFactory = sessionFactory();

        StreamSessionFactory factory = Streams.wrap(originalFactory);
        StreamSession session = factory.getCurrentSession();

        long count = session.createQuery("from User")
                .stream()
                .count();

        Optional<?> user1 = session.createQuery("from User where id = :id")
                .setParameter("id", 1l)
                .optionalResult();

        Optional<User> user2 = session.createTypedQuery("from User where id = :id", User.class)
                .setParameter("id", 1l)
                .stream()
                .findFirst();

        Optional<?> user3 = session.getOptional("User", 1l);
    }

    private SessionFactory sessionFactory() {
        SessionFactory sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        Query query = mock(Query.class);

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery(any())).thenReturn(query);
        when(session.get(any(String.class), any(Long.class))).thenReturn(new Object());

        when(query.setParameter(any(), any())).thenReturn(query);
        when(query.list()).thenReturn(new ArrayList());
        when(query.uniqueResult()).thenReturn(new Object());

        return sessionFactory;
    }
}