/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams.internal;

import org.hibernate.*;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.Connection;

import static org.mockito.Mockito.mock;

/**
 * Tests the {@link SessionDelegate} class.
 *
 * @author Jakub Narloch
 */
@SuppressWarnings("unchecked")
public class SessionDelegateTest extends BaseDelegateTest<SessionDelegate, Session> {

    /**
     * Represents the instance of the tested class.
     */
    private SessionDelegate instance;

    /**
     * The mocked {@link Session} instance.
     */
    @Mock
    private Session session;

    /**
     * {@inheritDoc}
     */
    @Override
    protected SessionDelegate getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Session getMock() {
        return session;
    }

    /**
     * Sets up the test environment.
     *
     * @throws Exception if any error occurs
     */
    @Before
    public void setUp() throws Exception {

        instance = new SessionDelegate(session);
    }

    @Test
    public void testGetTenantIdentifier() throws Exception {

        // then
        verifyMethodCall(SharedSessionContract::getTenantIdentifier);
    }

    @Test
    public void testBeginTransaction() throws Exception {

        // then
        verifyMethodCall(SharedSessionContract::beginTransaction);
    }

    @Test
    public void testGetTransaction() throws Exception {

        // then
        verifyMethodCall(SharedSessionContract::getTransaction);
    }

    @Test
    public void testGetNamedQuery() throws Exception {

        // given
        final String queryName = "queryName";

        // then
        verifyMethodCall(s -> s.getNamedQuery(queryName));
    }

    @Test
    public void testGetTypedNamedQuery() throws Exception {

        // given
        final String queryName = "queryName";
        final Class<?> clazz = Object.class;

        // when
        instance.getTypedNamedQuery(queryName, clazz);

        // then
        verify().getNamedQuery(queryName);
    }

    @Test
    public void testCreateQuery() throws Exception {

        // given
        final String query = "query";

        // then
        verifyMethodCall(s -> s.createQuery(query));
    }

    @Test
    public void testCreateTypedQuery() throws Exception {

        // given
        final String query = "query";
        final Class<?> clazz = Object.class;

        // when
        instance.createTypedQuery(query, clazz);

        // then
        verify().createQuery(query);
    }

    @Test
    public void testCreateSQLQuery() throws Exception {

        // given
        final String query = "query";

        // then
        verifyMethodCall(s -> s.createSQLQuery(query));
    }

    @Test
    public void testCreateTypedSQLQuery() throws Exception {

        // given
        final String query = "query";
        final Class<?> clazz = Object.class;

        // when
        instance.createTypedSQLQuery(query, clazz);

        // then
        verify().createSQLQuery(query);
    }

    @Test
    public void testGetNamedProcedureCall() throws Exception {

        // given
        final String proc = "proc";

        // then
        verifyMethodCall(s -> s.getNamedProcedureCall(proc));
    }

    @Test
    public void testCreateStoredProcedureCall() throws Exception {

        // given
        final String proc = "proc";

        // then
        verifyMethodCall(s -> s.createStoredProcedureCall(proc));
    }

    @Test
    public void testCreateStoredProcedureCall1() throws Exception {

        // given
        final String proc = "proc";
        final Class<Object> result = Object.class;

        // then
        verifyMethodCall(s -> s.createStoredProcedureCall(proc, result));
    }

    @Test
    public void testCreateStoredProcedureCall2() throws Exception {

        // given
        final String proc = "proc";
        final Class<Object> result = Object.class;

        // then
        verifyMethodCall(s -> s.createStoredProcedureCall(proc, result));
    }

    @Test
    public void testCreateCriteria() throws Exception {

        // given
        final Class<Object> persistentClass = Object.class;

        // then
        verifyMethodCall(s -> s.createCriteria(persistentClass));
    }

    @Test
    public void testCreateCriteria1() throws Exception {

        // given
        final Class<Object> persistentClass = Object.class;
        final String alias = "alias";

        // then
        verifyMethodCall(s -> s.createCriteria(persistentClass, alias));
    }

    @Test
    public void testCreateCriteria2() throws Exception {

        // given
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.createCriteria(entityName));
    }

    @Test
    public void testCreateCriteria3() throws Exception {

        // given
        final String entityName = "entityName";
        final String alias = "alias";

        // then
        verifyMethodCall(s -> s.createCriteria(entityName, alias));
    }

    @Test
    public void testGetOptional() throws Exception {

        // given
        final Class<Object> clazz = Object.class;
        final long id = 1l;

        // when
        instance.getOptional(clazz, id);

        // then
        Mockito.verify(session).get(clazz, id);
    }

    @Test
    public void testGetOptional1() throws Exception {

        // given
        final Class<Object> clazz = Object.class;
        final long id = 1l;
        final LockOptions lockOptions = LockOptions.READ;

        // when
        instance.getOptional(clazz, id, lockOptions);

        // then
        Mockito.verify(session).get(clazz, id, lockOptions);
    }

    @Test
    public void testGetOptional2() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;

        // when
        instance.getOptional(entityName, id);

        // then
        Mockito.verify(session).get(entityName, id);
    }

    @Test
    public void testGetOptional3() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;
        final LockOptions lockOptions = LockOptions.READ;

        // when
        instance.getOptional(entityName, id, lockOptions);

        // then
        Mockito.verify(session).get(entityName, id, lockOptions);
    }

    @Test
    public void testSessionWithOptions() throws Exception {

        // then
        verifyMethodCall(Session::sessionWithOptions);
    }

    @Test
    public void testFlush() throws Exception {

        // then
        verifyMethodCall(Session::flush);
    }

    @Test
    public void testSetFlushMode() throws Exception {

        // given
        final FlushMode flushMode = FlushMode.ALWAYS;

        // then
        verifyMethodCall(s -> s.setFlushMode(flushMode));
    }

    @Test
    public void testGetFlushMode() throws Exception {

        // then
        verifyMethodCall(Session::getFlushMode);
    }

    @Test
    public void testSetCacheMode() throws Exception {

        // given
        final CacheMode cacheMode = CacheMode.GET;

        // then
        verifyMethodCall(s -> s.setCacheMode(cacheMode));
    }

    @Test
    public void testGetCacheMode() throws Exception {

        // then
        verifyMethodCall(Session::getCacheMode);
    }

    @Test
    public void testGetSessionFactory() throws Exception {

        // then
        verifyMethodCall(Session::getSessionFactory);
    }

    @Test
    public void testClose() throws Exception {

        // then
        verifyMethodCall(Session::close);
    }

    @Test
    public void testCancelQuery() throws Exception {

        // then
        verifyMethodCall(Session::cancelQuery);
    }

    @Test
    public void testIsOpen() throws Exception {

        // then
        verifyMethodCall(Session::isOpen);
    }

    @Test
    public void testIsConnected() throws Exception {

        // then
        verifyMethodCall(Session::isConnected);
    }

    @Test
    public void testIsDirty() throws Exception {

        // then
        verifyMethodCall(Session::isDirty);
    }

    @Test
    public void testIsDefaultReadOnly() throws Exception {

        // then
        verifyMethodCall(Session::isDefaultReadOnly);
    }

    @Test
    public void testSetDefaultReadOnly() throws Exception {

        // given
        final boolean readOnly = true;

        // then
        verifyMethodCall(s -> s.setDefaultReadOnly(readOnly));
    }

    @Test
    public void testGetIdentifier() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.getIdentifier(object));
    }

    @Test
    public void testContains() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.contains(object));
    }

    @Test
    public void testEvict() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.evict(object));
    }

    @Test
    public void testLoad() throws Exception {

        // given
        final Class<Object> clazz = Object.class;
        final long id = 1l;

        // then
        verifyMethodCall(s -> s.load(clazz, id));
    }

    @Test
    public void testLoad1() throws Exception {

        // given
        final Class<Object> clazz = Object.class;
        final long id = 1l;
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(s -> s.load(clazz, id, lockMode));
    }

    @Test
    public void testLoad2() throws Exception {

        // given
        final Class<Object> clazz = Object.class;
        final long id = 1l;
        final LockOptions lockOptions = LockOptions.READ;

        // then
        verifyMethodCall(s -> s.load(clazz, id, lockOptions));
    }

    @Test
    public void testLoad3() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;

        // then
        verifyMethodCall(s -> s.load(entityName, id));
    }

    @Test
    public void testLoad4() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(s -> s.load(entityName, id, lockMode));
    }

    @Test
    public void testLoad5() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;
        final LockOptions lockOptions = LockOptions.READ;

        // then
        verifyMethodCall(s -> s.load(entityName, id, lockOptions));
    }

    @Test
    public void testLoad6() throws Exception {

        // given
        final Object object = new Object();
        final long id = 1l;

        // then
        verifyMethodCall(s -> s.load(object, id));
    }

    @Test
    public void testReplicate() throws Exception {

        // given
        final Object object = new Object();
        final ReplicationMode replicationMode = ReplicationMode.OVERWRITE;

        // then
        verifyMethodCall(s -> s.replicate(object, replicationMode));
    }

    @Test
    public void testReplicate1() throws Exception {

        // given
        final String entityName = "entityName";
        final Object object = new Object();
        final ReplicationMode replicationMode = ReplicationMode.OVERWRITE;

        // then
        verifyMethodCall(s -> s.replicate(entityName, object, replicationMode));
    }

    @Test
    public void testSave() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.save(object));
    }

    @Test
    public void testSave1() throws Exception {

        // given
        final Object object = new Object();
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.save(entityName, object));
    }

    @Test
    public void testSaveOrUpdate() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.saveOrUpdate(object));
    }

    @Test
    public void testSaveOrUpdate1() throws Exception {

        // given
        final Object object = new Object();
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.saveOrUpdate(entityName, object));
    }

    @Test
    public void testUpdate() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.update(object));
    }

    @Test
    public void testUpdate1() throws Exception {

        // given
        final Object object = new Object();
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.update(entityName, object));
    }

    @Test
    public void testMerge() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.merge(object));
    }

    @Test
    public void testMerge1() throws Exception {

        // given
        final Object object = new Object();
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.merge(entityName, object));
    }

    @Test
    public void testPersist() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.persist(object));
    }

    @Test
    public void testPersist1() throws Exception {

        // given
        final Object object = new Object();
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.persist(entityName, object));
    }

    @Test
    public void testDelete() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.delete(object));
    }

    @Test
    public void testDelete1() throws Exception {

        // given
        final Object object = new Object();
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.delete(entityName, object));
    }

    @Test
    public void testLock() throws Exception {

        // given
        final LockMode lockMode = LockMode.OPTIMISTIC;
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.lock(entityName, lockMode));
    }

    @Test
    public void testLock1() throws Exception {

        // given
        final Object object = new Object();
        final LockMode lockMode = LockMode.OPTIMISTIC;
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.lock(entityName, object, lockMode));
    }

    @Test
    public void testBuildLockRequest() throws Exception {

        // given
        final LockOptions lockOptions = LockOptions.READ;

        // then
        verifyMethodCall(s -> s.buildLockRequest(lockOptions));
    }

    @Test
    public void testRefresh() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.refresh(object));
    }

    @Test
    public void testRefresh1() throws Exception {

        // given
        final Object object = new Object();
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.refresh(entityName, object));
    }

    @Test
    public void testRefresh2() throws Exception {

        // given
        final Object object = new Object();
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(s -> s.refresh(object, lockMode));
    }

    @Test
    public void testRefresh3() throws Exception {

        // given
        final Object object = new Object();
        final LockOptions lockOptions = LockOptions.READ;

        // then
        verifyMethodCall(s -> s.refresh(object, lockOptions));
    }

    @Test
    public void testRefresh4() throws Exception {

        // given
        final Object object = new Object();
        final String entityName = "entityName";
        final LockOptions lockOptions = LockOptions.READ;

        // then
        verifyMethodCall(s -> s.refresh(entityName, object, lockOptions));
    }

    @Test
    public void testGetCurrentLockMode() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.getCurrentLockMode(object));
    }

    @Test
    public void testCreateFilter() throws Exception {

        // given
        final Object objectCollection = new Object();
        final String queryString = "query";

        // then
        verifyMethodCall(s -> s.createFilter(objectCollection, queryString));
    }

    @Test
    public void testClear() throws Exception {

        // then
        verifyMethodCall(Session::clear);
    }

    @Test
    public void testGet() throws Exception {

        // given
        final Class<?> clazz = Object.class;
        final long id = 1l;

        // then
        verifyMethodCall(s -> s.get(clazz, id));
    }

    @Test
    public void testGet1() throws Exception {

        // given
        final Class<?> clazz = Object.class;
        final long id = 1l;
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(s -> s.get(clazz, id, lockMode));
    }

    @Test
    public void testGet2() throws Exception {

        // given
        final Class<?> clazz = Object.class;
        final long id = 1l;
        final LockOptions lockOptions = LockOptions.READ;

        // then
        verifyMethodCall(s -> s.get(clazz, id, lockOptions));
    }

    @Test
    public void testGet3() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;

        // then
        verifyMethodCall(s -> s.get(entityName, id));
    }

    @Test
    public void testGet4() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(s -> s.get(entityName, id, lockMode));
    }

    @Test
    public void testGet5() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;
        final LockOptions lockOptions = LockOptions.READ;

        // then
        verifyMethodCall(s -> s.get(entityName, id, lockOptions));
    }

    @Test
    public void testGetEntityName() throws Exception {

        // given
        final Object object = new Object();

        // then
        verifyMethodCall(s -> s.getEntityName(object));
    }

    @Test
    public void testById() throws Exception {

        // given
        final Class<Object> clazz = Object.class;

        // then
        verifyMethodCall(s -> s.byId(clazz));
    }

    @Test
    public void testById1() throws Exception {

        // given
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.byId(entityName));
    }

    @Test
    public void testByNaturalId() throws Exception {

        // given
        final Class<Object> clazz = Object.class;

        // then
        verifyMethodCall(s -> s.byNaturalId(clazz));
    }

    @Test
    public void testByNaturalId1() throws Exception {

        // given
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.byNaturalId(entityName));
    }

    @Test
    public void testBySimpleNaturalId() throws Exception {

        // given
        final Class<Object> clazz = Object.class;

        // then
        verifyMethodCall(s -> s.bySimpleNaturalId(clazz));
    }

    @Test
    public void testBySimpleNaturalId1() throws Exception {

        // given
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.bySimpleNaturalId(entityName));
    }

    @Test
    public void testEnableFilter() throws Exception {

        // given
        final String filterName = "entityName";

        // then
        verifyMethodCall(s -> s.enableFilter(filterName));
    }

    @Test
    public void testGetEnabledFilter() throws Exception {

        // given
        final String filterName = "entityName";

        // then
        verifyMethodCall(s -> s.getEnabledFilter(filterName));
    }

    @Test
    public void testDisableFilter() throws Exception {

        // given
        final String filterName = "entityName";

        // then
        verifyMethodCall(s -> s.disableFilter(filterName));
    }

    @Test
    public void testGetStatistics() throws Exception {

        // then
        verifyMethodCall(Session::getStatistics);
    }

    @Test
    public void testIsReadOnly() throws Exception {

        // given
        final Object entity = new Object();

        // then
        verifyMethodCall(s -> s.isReadOnly(entity));
    }

    @Test
    public void testSetReadOnly() throws Exception {

        // given
        final Object entity = new Object();
        final boolean readOnly = true;

        // then
        verifyMethodCall(s -> s.setReadOnly(entity, readOnly));
    }

    @Test
    public void testDoWork() throws Exception {

        // given
        final Work work = null;

        // then
        verifyMethodCall(s -> s.doWork(work));
    }

    @Test
    public void testDoReturningWork() throws Exception {

        // given
        final ReturningWork work = null;

        // then
        verifyMethodCall(s -> s.doReturningWork(work));
    }

    @Test
    public void testDisconnect() throws Exception {

        // then
        verifyMethodCall(Session::disconnect);
    }

    @Test
    public void testReconnect() throws Exception {

        // given
        final Connection connection = mock(Connection.class);

        // then
        verifyMethodCall(s -> s.reconnect(connection));
    }

    @Test
    public void testIsFetchProfileEnabled() throws Exception {

        // given
        final String name = "name";

        // then
        verifyMethodCall(s -> s.isFetchProfileEnabled(name));
    }

    @Test
    public void testEnableFetchProfile() throws Exception {

        // given
        final String name = "name";

        // then
        verifyMethodCall(s -> s.enableFetchProfile(name));
    }

    @Test
    public void testDisableFetchProfile() throws Exception {

        // given
        final String name = "name";

        // then
        verifyMethodCall(s -> s.disableFetchProfile(name));
    }

    @Test
    public void testGetTypeHelper() throws Exception {

        // then
        verifyMethodCall(Session::getTypeHelper);
    }

    @Test
    public void testGetLobHelper() throws Exception {

        // then
        verifyMethodCall(Session::getLobHelper);
    }

    @Test
    public void testAddEventListeners() throws Exception {

        // given
        final SessionEventListener listener = mock(SessionEventListener.class);

        // then
        verifyMethodCall(s -> s.addEventListeners(listener));
    }
}