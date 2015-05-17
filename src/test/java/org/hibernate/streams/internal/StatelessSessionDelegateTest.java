package org.hibernate.streams.internal;

import org.hibernate.LockMode;
import org.hibernate.SharedSessionContract;
import org.hibernate.StatelessSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Tests the {@link StatelessSessionDelegate} class.
 *
 * @author Jakub Narloch
 */
public class StatelessSessionDelegateTest extends BaseDelegateTest<StatelessSessionDelegate, StatelessSession> {

    /**
     * Represents the instance of the tested class.
     */
    private StatelessSessionDelegate instance;

    /**
     * The mocked {@link StatelessSession} instance.
     */
    @Mock
    private StatelessSession statelessSession;

    /**
     * {@inheritDoc}
     */
    @Override
    protected StatelessSessionDelegate getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected StatelessSession getMock() {
        return statelessSession;
    }

    /**
     * Sets up the test environment.
     *
     * @throws Exception if any error occurs
     */
    @Before
    public void setUp() throws Exception {

        instance = new StatelessSessionDelegate(statelessSession);
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
    public void testCreateQuery() throws Exception {

        // given
        final String query = "query";

        // then
        verifyMethodCall(s -> s.createQuery(query));
    }

    @Test
    public void testCreateSQLQuery() throws Exception {

        // given
        final String query = "query";

        // then
        verifyMethodCall(s -> s.createSQLQuery(query));
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
        final String result = "result";

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
        verify().get(clazz, id);
    }

    @Test
    public void testGetOptional1() throws Exception {

        // given
        final Class<Object> clazz = Object.class;
        final long id = 1l;
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // when
        instance.getOptional(clazz, id, lockMode);

        // then
        verify().get(clazz, id, lockMode);
    }

    @Test
    public void testGetOptional2() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;

        // when
        instance.getOptional(entityName, id);

        // then
        verify().get(entityName, id);
    }

    @Test
    public void testGetOptional3() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // when
        instance.getOptional(entityName, id, lockMode);

        // then
        verify().get(entityName, id, lockMode);
    }

    @Test
    public void testClose() throws Exception {

        // then
        verifyMethodCall(StatelessSession::close);
    }

    @Test
    public void testInsert() throws Exception {

        // given
        final Object entity = new Object();

        // then
        verifyMethodCall(s -> s.insert(entity));
    }

    @Test
    public void testInsert1() throws Exception {

        // given
        final Object entity = "entityName";
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.insert(entityName, entity));
    }

    @Test
    public void testUpdate() throws Exception {

        // given
        final Object entity = "entityName";

        // then
        verifyMethodCall(s -> s.update(entity));
    }

    @Test
    public void testUpdate1() throws Exception {

        // given
        final Object entity = "entityName";
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.update(entityName, entity));
    }

    @Test
    public void testDelete() throws Exception {

        // given
        final Object entity = "entityName";

        // then
        verifyMethodCall(s -> s.delete(entity));
    }

    @Test
    public void testDelete1() throws Exception {

        // given
        final Object entity = "entityName";
        final String entityName = "entityName";

        // then
        verifyMethodCall(s -> s.delete(entityName, entity));
    }

    @Test
    public void testGet() throws Exception {

        // given
        final Class<Object> clazz = Object.class;
        final long id = 1l;

        // then
        verifyMethodCall(s -> s.get(clazz, id));
    }

    @Test
    public void testGet1() throws Exception {

        // given
        final Class<Object> clazz = Object.class;
        final long id = 1l;
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(s -> s.get(clazz, id, lockMode));
    }

    @Test
    public void testGet2() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;

        // then
        verifyMethodCall(s -> s.get(entityName, id));
    }

    @Test
    public void testGet3() throws Exception {

        // given
        final String entityName = "entityName";
        final long id = 1l;
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(s -> s.get(entityName, id, lockMode));
    }

    @Test
    public void testRefresh() throws Exception {

        // given
        final Object entity = new Object();

        // then
        verifyMethodCall(s -> s.refresh(entity));
    }

    @Test
    public void testRefresh1() throws Exception {

        // given
        final String entityName = "entityName";
        final Object entity = new Object();

        // then
        verifyMethodCall(s -> s.refresh(entityName, entity));
    }

    @Test
    public void testRefresh2() throws Exception {

        // given
        final Object entity = new Object();
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(s -> s.refresh(entity, lockMode));
    }

    @Test
    public void testRefresh3() throws Exception {

        // given
        final String entityName = "entityName";
        final Object entity = new Object();
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(s -> s.refresh(entityName, entity, lockMode));
    }

    @Test
    public void testConnection() throws Exception {

        // then
        verifyMethodCall(StatelessSession::connection);
    }
}