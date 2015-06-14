package com.github.jmnarloch.hstreams.internal;

import com.github.jmnarloch.hstreams.*;
import com.github.jmnarloch.hstreams.model.User;
import org.hibernate.Transaction;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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