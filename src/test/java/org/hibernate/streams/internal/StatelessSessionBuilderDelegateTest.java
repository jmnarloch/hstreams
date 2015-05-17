package org.hibernate.streams.internal;

import org.hibernate.StatelessSessionBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.sql.Connection;

import static org.mockito.Mockito.mock;

/**
 * Tests the {@link StatelessSessionBuilderDelegate} class.
 *
 * @author Jakub Narloch
 */
public class StatelessSessionBuilderDelegateTest extends
        BaseDelegateTest<StatelessSessionBuilderDelegate, StatelessSessionBuilder> {

    /**
     * Represents the instance of the tested class.
     */
    private StatelessSessionBuilderDelegate instance;

    /**
     * The mocked {@link StatelessSessionBuilder} instance.
     */
    @Mock
    private StatelessSessionBuilder statelessSessionBuilder;

    /**
     * Sets up the test environment.
     *
     * @throws Exception if any error occurs
     */
    @Before
    public void setUp() throws Exception {

        instance = new StatelessSessionBuilderDelegate(statelessSessionBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected StatelessSessionBuilderDelegate getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected StatelessSessionBuilder getMock() {
        return statelessSessionBuilder;
    }

    @Test
    public void testOpenStatelessSession() throws Exception {

        // then
        verifyMethodCall(StatelessSessionBuilder::openStatelessSession);
    }

    @Test
    public void testConnection() throws Exception {

        // given
        final Connection connection = mock(Connection.class);

        // then
        verifyMethodCall(sb -> sb.connection(connection));
    }

    @Test
    public void testTenantIdentifier() throws Exception {

        // given
        final String tenant = "tenant";

        // then
        verifyMethodCall(sb -> sb.tenantIdentifier(tenant));
    }

}