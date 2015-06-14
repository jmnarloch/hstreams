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

import com.github.jmnarloch.hstreams.*;
import com.github.jmnarloch.hstreams.model.User;
import org.hibernate.Transaction;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Integration tests {@link QueryDelegate}.
 *
 * @author Jakub Narloch
 */
public class QueryDelegateITTest extends BaseCoreFunctionalTestCase {

    /**
     * The stream session factory instance used for testing.
     */
    private StreamSessionFactory streamSessionFactory;

    /**
     * The stream session instance used for testing.
     */
    private StreamSession streamSession;

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[]{User.class};
    }

    @Before
    public void setUp() throws Exception {

        streamSessionFactory = Streams.wrap(sessionFactory());
        streamSession = streamSessionFactory.openSession();

        final Transaction transaction = streamSession.beginTransaction();
        streamSession.createQuery("delete from User").executeUpdate();
        streamSession.save(createUser(1, "John", "Smith"));
        streamSession.save(createUser(2, "John", "Doe"));
        transaction.commit();
    }

    @Test
    public void shouldReturnEmptyStream() {

        // given
        final StreamQuery query = streamSession.createQuery("from User u where u.secondName = 'None'");

        // then
        assertNotNull(query.stream());
        assertEquals(0, query.stream().count());
    }

    @Test
    public void shouldReturnNonEmptyStream() {

        // given
        final StreamQuery query = streamSession.createQuery("from User");

        // then
        assertNotNull(query.stream());
        assertEquals(2, query.stream().count());
    }

    @Test
    public void shouldReturnNonEmptyUserStream() {

        // given
        final StreamTypedQuery<User> query = streamSession.createTypedQuery("from User", User.class);

        // then
        assertNotNull(query.stream());
        assertEquals(2, query.stream().count());

        final Optional<User> found = query.stream()
                .filter(u -> "Doe".equals(u.getSecondName()))
                .findFirst();
        assertTrue(found.isPresent());
        assertEquals("John", found.get().getFirstName());
    }

    @Test
    public void shouldReturnOptionalUser() {

        // when
        final Optional<?> user = streamSession.getOptional(User.class, 1l);
    }

    private static User createUser(int id, String firstName, String secondName) {
        final User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        return user;
    }
}