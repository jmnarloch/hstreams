package org.hibernate.streams.internal;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.Interceptor;
import org.hibernate.SessionEventListener;
import org.hibernate.streams.StreamSessionBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.sql.Connection;

import static org.mockito.Mockito.mock;

/**
 * Tests the {@link StreamSessionBuilderDelegate} class.
 *
 * @author Jakub Narloch
 */
public class StreamSessionBuilderDelegateTest extends
        BaseDelegateTest<StreamSessionBuilderDelegate, StreamSessionBuilder> {

    /**
     * Represents the instance of the tested class.
     */
    private StreamSessionBuilderDelegate instance;

    /**
     * The mocked {@link StreamSessionBuilder} instance.
     */
    @Mock
    private StreamSessionBuilder streamSessionBuilder;

    /**
     * {@inheritDoc}
     */
    @Override
    protected StreamSessionBuilderDelegate getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected StreamSessionBuilder getMock() {
        return streamSessionBuilder;
    }

    /**
     * Sets up the test environment.
     *
     * @throws Exception if any error occurs
     */
    @Before
    public void setUp() throws Exception {

        instance = new StreamSessionBuilderDelegate(streamSessionBuilder);
    }

    @Test
    public void testOpenSession() throws Exception {

        // then
        verifyMethodCall(StreamSessionBuilder::openSession);
    }

    @Test
    public void testInterceptor() throws Exception {

        // given
        final Interceptor interceptor = mock(Interceptor.class);

        // then
        verifyMethodCall(sb -> sb.interceptor(interceptor));
    }

    @Test
    public void testNoInterceptor() throws Exception {

        // then
        verifyMethodCall(StreamSessionBuilder::noInterceptor);
    }

    @Test
    public void testConnection() throws Exception {

        // given
        final Connection connection = mock(Connection.class);

        // then
        verifyMethodCall(sb -> sb.connection(connection));
    }

    @Test
    public void testConnectionReleaseMode() throws Exception {

        // given
        final ConnectionReleaseMode releaseMode = ConnectionReleaseMode.AFTER_STATEMENT;

        // then
        verifyMethodCall(sb -> sb.connectionReleaseMode(releaseMode));
    }

    @Test
    public void testAutoJoinTransactions() throws Exception {

        // given
        final boolean autoJoin = true;

        // then
        verifyMethodCall(sb -> sb.autoJoinTransactions(autoJoin));
    }

    @Test
    public void testAutoClose() throws Exception {

        // given
        final boolean autoClose = true;

        // then
        verifyMethodCall(sb -> sb.autoClose(autoClose));
    }

    @Test
    public void testFlushBeforeCompletion() throws Exception {

        // given
        final boolean flush = true;

        // then
        verifyMethodCall(sb -> sb.flushBeforeCompletion(flush));
    }

    @Test
    public void testTenantIdentifier() throws Exception {

        // given
        final String tenant = "tenant";

        // then
        verifyMethodCall(sb -> sb.tenantIdentifier(tenant));
    }

    @Test
    public void testEventListeners() throws Exception {

        // given
        final SessionEventListener listener = mock(SessionEventListener.class);

        // then
        verifyMethodCall(sb -> sb.eventListeners(listener));
    }

    @Test
    public void testClearEventListeners() throws Exception {

        // then
        verifyMethodCall(StreamSessionBuilder::clearEventListeners);
    }
}