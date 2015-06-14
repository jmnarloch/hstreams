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

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.naming.Referenceable;
import java.sql.Connection;

import static org.mockito.Mockito.mock;

/**
 * Tests the {@link SessionFactory} class.
 *
 * @author Jakub Narloch
 */
public class SessionFactoryDelegateTest extends BaseDelegateTest<SessionFactoryDelegate, SessionFactory> {

    /**
     * Represents the instance of the tested class.
     */
    private SessionFactoryDelegate instance;

    /**
     * The mocked {@link SessionFactory} instance.
     */
    @Mock
    private SessionFactory sessionFactory;

    /**
     * {@inheritDoc}
     */
    @Override
    protected SessionFactoryDelegate getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SessionFactory getMock() {
        return sessionFactory;
    }

    /**
     * Sets up the test environment.
     *
     * @throws Exception if any error occurs
     */
    @Before
    public void setUp() throws Exception {

        instance = new SessionFactoryDelegate(sessionFactory);
    }

    @Test
    public void testGetSessionFactoryOptions() throws Exception {

        // then
        verifyMethodCall(SessionFactory::getSessionFactoryOptions);
    }

    @Test
    public void testWithOptions() throws Exception {

        // then
        verifyMethodCall(SessionFactory::withOptions);
    }

    @Test
    public void testOpenSession() throws Exception {

        // then
        verifyMethodCall(SessionFactory::openSession);
    }

    @Test
    public void testGetCurrentSession() throws Exception {

        // then
        verifyMethodCall(SessionFactory::getCurrentSession);
    }

    @Test
    public void testWithStatelessOptions() throws Exception {

        // then
        verifyMethodCall(SessionFactory::withStatelessOptions);
    }

    @Test
    public void testOpenStatelessSession() throws Exception {

        // then
        verifyMethodCall(SessionFactory::openStatelessSession);
    }

    @Test
    public void testOpenStatelessSession1() throws Exception {

        // given
        final Connection connection = mock(Connection.class);

        // then
        verifyMethodCall(sf -> sf.openStatelessSession(connection));
    }

    @Test
    public void testGetClassMetadata() throws Exception {

        // given
        final Class<Object> clazz = Object.class;

        // then
        verifyMethodCall(sf -> sf.getClassMetadata(clazz));
    }

    @Test
    public void testGetClassMetadata1() throws Exception {

        // given
        String entityName = "Object";

        // then
        verifyMethodCall(sf -> sf.getClassMetadata(entityName));
    }

    @Test
    public void testGetCollectionMetadata() throws Exception {

        // given
        String role = "role";

        // then
        verifyMethodCall(sf -> sf.getCollectionMetadata(role));
    }

    @Test
    public void testGetAllClassMetadata() throws Exception {

        // then
        verifyMethodCall(SessionFactory::getAllClassMetadata);
    }

    @Test
    public void testGetAllCollectionMetadata() throws Exception {

        // then
        verifyMethodCall(SessionFactory::getAllCollectionMetadata);
    }

    @Test
    public void testGetStatistics() throws Exception {

        // then
        verifyMethodCall(SessionFactory::getStatistics);
    }

    @Test
    public void testClose() throws Exception {

        // then
        verifyMethodCall(SessionFactory::close);
    }

    @Test
    public void testIsClosed() throws Exception {

        // then
        verifyMethodCall(SessionFactory::isClosed);
    }

    @Test
    public void testGetCache() throws Exception {

        // then
        verifyMethodCall(SessionFactory::getCache);
    }

    @Test
    public void testEvict() throws Exception {

        // given
        final Class<Object> clazz = Object.class;

        // then
        verifyMethodCall(sf -> sf.evict(clazz));
    }

    @Test
    public void testEvict1() throws Exception {

        // given
        final Class<Object> clazz = Object.class;
        final long id = 1l;

        // then
        verifyMethodCall(sf -> sf.evict(clazz, id));
    }

    @Test
    public void testEvictEntity() throws Exception {

        // given
        final String entityName = "Object";

        // then
        verifyMethodCall(sf -> sf.evictEntity(entityName));
    }

    @Test
    public void testEvictEntity1() throws Exception {

        // given
        final String entityName = "Object";
        final long id = 1l;

        // then
        verifyMethodCall(sf -> sf.evictEntity(entityName, id));
    }

    @Test
    public void testEvictCollection() throws Exception {

        // given
        final String roleName = "roleName";

        // then
        verifyMethodCall(sf -> sf.evictCollection(roleName));
    }

    @Test
    public void testEvictCollection1() throws Exception {

        // given
        final String roleName = "roleName";
        final long id = 1l;

        // then
        verifyMethodCall(sf -> sf.evictCollection(roleName, id));
    }

    @Test
    public void testEvictQueries() throws Exception {

        // then
        verifyMethodCall(SessionFactory::evictQueries);
    }

    @Test
    public void testEvictQueries1() throws Exception {

        // given
        final String cache = "cache";

        // then
        verifyMethodCall(sf -> sf.evictQueries(cache));
    }

    @Test
    public void testGetDefinedFilterNames() throws Exception {

        // then
        verifyMethodCall(SessionFactory::getDefinedFilterNames);
    }

    @Test
    public void testGetFilterDefinition() throws Exception {

        // given
        final String filterName = "filterName";

        // then
        verifyMethodCall(sf -> sf.getFilterDefinition(filterName));
    }

    @Test
    public void testContainsFetchProfileDefinition() throws Exception {

        // given
        final String name = "name";

        // then
        verifyMethodCall(sf -> sf.containsFetchProfileDefinition(name));
    }

    @Test
    public void testGetTypeHelper() throws Exception {

        // then
        verifyMethodCall(SessionFactory::getTypeHelper);
    }

    @Test
    public void testGetReference() throws Exception {

        // then
        verifyMethodCall(Referenceable::getReference);
    }
}