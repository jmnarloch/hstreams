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

import org.hibernate.*;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static org.mockito.Mockito.mock;

/**
 * Tests the {@link QueryDelegate} class.
 *
 * @author Jakub Narloch
 */
public class QueryDelegateTest extends BaseDelegateTest<QueryDelegate, Query> {

    /**
     * Represents the instance of the tested class.
     */
    private QueryDelegate instance;

    /**
     * The mocked {@link Query} instance.
     */
    @Mock
    private Query query;

    /**
     * Sets up the test environment.
     *
     * @throws Exception if any error occurs
     */
    @Before
    public void setUp() throws Exception {

        instance = new QueryDelegate(query);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected QueryDelegate getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Query getMock() {
        return query;
    }

    @Test
    public void testStream() throws Exception {

        // when
        instance.stream();

        // then
        verify().list();
    }

    @Test
    public void testParallelStream() throws Exception {

        // when
        instance.parallelStream();

        // then
        verify().list();
    }

    @Test
    public void testOptionalResult() throws Exception {

        // when
        instance.optionalResult();

        // then
        verify().uniqueResult();
    }

    @Test
    public void testGetQueryString() throws Exception {

        // then
        verifyMethodCall(Query::getQueryString);
    }

    @Test
    public void testGetMaxResults() throws Exception {

        // then
        verifyMethodCall(q -> q.getMaxResults());
    }

    @Test
    public void testSetMaxResults() throws Exception {

        // given
        final int maxResults = 10;

        // then
        verifyMethodCall(q -> q.setMaxResults(maxResults));
    }

    @Test
    public void testGetFirstResult() throws Exception {

        // then
        verifyMethodCall(Query::getFirstResult);
    }

    @Test
    public void testSetFirstResult() throws Exception {

        // given
        final int firstResult = 10;

        // then
        verifyMethodCall(q -> q.setFirstResult(firstResult));
    }

    @Test
    public void testGetFlushMode() throws Exception {

        // then
        verifyMethodCall(BasicQueryContract::getFlushMode);
    }

    @Test
    public void testSetFlushMode() throws Exception {

        // given
        final FlushMode flushMode = FlushMode.ALWAYS;

        // then
        verifyMethodCall(q -> q.setFlushMode(flushMode));
    }

    @Test
    public void testGetCacheMode() throws Exception {

        // then
        verifyMethodCall(BasicQueryContract::getCacheMode);
    }

    @Test
    public void testSetCacheMode() throws Exception {

        // given
        final CacheMode cacheMode = CacheMode.GET;

        // then
        verifyMethodCall(q -> q.setCacheMode(cacheMode));
    }

    @Test
    public void testIsCacheable() throws Exception {

        // then
        verifyMethodCall(BasicQueryContract::isCacheable);
    }

    @Test
    public void testSetCacheable() throws Exception {

        // given
        final boolean cacheable = true;

        // then
        verifyMethodCall(q -> q.setCacheable(cacheable));
    }

    @Test
    public void testGetCacheRegion() throws Exception {

        // then
        verifyMethodCall(BasicQueryContract::getCacheRegion);
    }

    @Test
    public void testSetCacheRegion() throws Exception {

        // given
        final String cacheRegion = "cacheRegion";

        // then
        verifyMethodCall(q -> q.setCacheRegion(cacheRegion));
    }

    @Test
    public void testGetTimeout() throws Exception {

        // then
        verifyMethodCall(BasicQueryContract::getTimeout);
    }

    @Test
    public void testSetTimeout() throws Exception {

        // given
        final int timeout = 10;

        // then
        verifyMethodCall(q -> q.setTimeout(timeout));
    }

    @Test
    public void testGetFetchSize() throws Exception {

        // then
        verifyMethodCall(BasicQueryContract::getFetchSize);
    }

    @Test
    public void testSetFetchSize() throws Exception {

        // given
        final int fetchSize = 10;

        // then
        verifyMethodCall(q -> q.setFetchSize(fetchSize));
    }

    @Test
    public void testIsReadOnly() throws Exception {

        // then
        verifyMethodCall(BasicQueryContract::isReadOnly);
    }

    @Test
    public void testSetReadOnly() throws Exception {

        // given
        final boolean readOnly = true;

        // then
        verifyMethodCall(q -> q.setReadOnly(readOnly));
    }

    @Test
    public void testGetReturnTypes() throws Exception {

        // then
        verifyMethodCall(BasicQueryContract::getReturnTypes);
    }

    @Test
    public void testGetLockOptions() throws Exception {

        // then
        verifyMethodCall(Query::getLockOptions);
    }

    @Test
    public void testSetLockOptions() throws Exception {

        // given
        final LockOptions lockOptions = LockOptions.READ;

        // then
        verifyMethodCall(q -> q.setLockOptions(lockOptions));
    }

    @Test
    public void testSetLockMode() throws Exception {

        // given
        final String alias = "alias";
        final LockMode lockMode = LockMode.OPTIMISTIC;

        // then
        verifyMethodCall(q -> q.setLockMode(alias, lockMode));
    }

    @Test
    public void testGetComment() throws Exception {

        // then
        verifyMethodCall(Query::getComment);
    }

    @Test
    public void testSetComment() throws Exception {

        // given
        final String comment = "comment";

        // then
        verifyMethodCall(q -> q.setComment(comment));
    }

    @Test
    public void testAddQueryHint() throws Exception {

        // given
        final String hint = "hint";

        // then
        verifyMethodCall(q -> q.addQueryHint(hint));
    }

    @Test
    public void testGetReturnAliases() throws Exception {

        // then
        verifyMethodCall(Query::getReturnAliases);
    }

    @Test
    public void testGetNamedParameters() throws Exception {

        // then
        verifyMethodCall(Query::getNamedParameters);
    }

    @Test
    public void testIterate() throws Exception {

        // then
        verifyMethodCall(Query::iterate);
    }

    @Test
    public void testScroll() throws Exception {

        // then
        verifyMethodCall(Query::scroll);
    }

    @Test
    public void testScroll1() throws Exception {

        // given
        final ScrollMode scrollMode = ScrollMode.SCROLL_INSENSITIVE;

        // then
        verifyMethodCall(q -> q.scroll(scrollMode));
    }

    @Test
    public void testList() throws Exception {

        // then
        verifyMethodCall(Query::list);
    }

    @Test
    public void testUniqueResult() throws Exception {

        // then
        verifyMethodCall(Query::uniqueResult);
    }

    @Test
    public void testExecuteUpdate() throws Exception {

        // then
        verifyMethodCall(Query::executeUpdate);
    }

    @Test
    public void testSetParameter() throws Exception {

        // given
        final int position = 0;
        final Object value = new Object();

        // then
        verifyMethodCall(q -> q.setParameter(position, value));
    }

    @Test
    public void testSetParameter1() throws Exception {

        // given
        final int position = 0;
        final Object value = new Object();
        final Type type = null;

        // then
        verifyMethodCall(q -> q.setParameter(position, value, type));
    }

    @Test
    public void testSetParameter2() throws Exception {

        // given
        final String name = "name";
        final Object value = new Object();

        // then
        verifyMethodCall(q -> q.setParameter(name, value));
    }

    @Test
    public void testSetParameter3() throws Exception {

        // given
        final String name = "name";
        final Object value = new Object();
        final Type type = null;

        // then
        verifyMethodCall(q -> q.setParameter(name, value, type));
    }

    @Test
    public void testSetParameters() throws Exception {

        // given
        final Object[] values = new Object[0];
        final Type[] types = new Type[0];

        // then
        verifyMethodCall(q -> q.setParameters(values, types));
    }

    @Test
    public void testSetParameterList() throws Exception {

        // given
        final String name = "name";
        final Collection values = Collections.emptyList();

        // then
        verifyMethodCall(q -> q.setParameterList(name, values));
    }

    @Test
    public void testSetParameterList1() throws Exception {

        // given
        final String name = "name";
        final Collection values = Collections.emptyList();
        final Type type = null;

        // then
        verifyMethodCall(q -> q.setParameterList(name, values, type));
    }

    @Test
    public void testSetParameterList2() throws Exception {

        // given
        final String name = "name";
        final Object[] values = new Object[0];

        // then
        verifyMethodCall(q -> q.setParameterList(name, values));
    }

    @Test
    public void testSetParameterList3() throws Exception {

        // given
        final String name = "name";
        final Object[] values = new Object[0];
        final Type type = null;

        // then
        verifyMethodCall(q -> q.setParameterList(name, values, type));
    }

    @Test
    public void testSetProperties() throws Exception {

        // given
        final Object obj = new Object();

        // then
        verifyMethodCall(q -> q.setProperties(obj));
    }

    @Test
    public void testSetProperties1() throws Exception {

        // given
        final Map map = Collections.emptyMap();

        // then
        verifyMethodCall(q -> q.setProperties(map));
    }

    @Test
    public void testSetString() throws Exception {

        // given
        final int position = 0;
        final String value = "value";

        // then
        verifyMethodCall(q -> q.setString(position, value));
    }

    @Test
    public void testSetCharacter() throws Exception {

        // given
        final int position = 0;
        final char value = 'c';

        // then
        verifyMethodCall(q -> q.setCharacter(position, value));
    }

    @Test
    public void testSetBoolean() throws Exception {

        // given
        final int position = 0;
        final boolean value = true;

        // then
        verifyMethodCall(q -> q.setBoolean(position, value));
    }

    @Test
    public void testSetByte() throws Exception {

        // given
        final int position = 0;
        final byte value = 0;

        // then
        verifyMethodCall(q -> q.setByte(position, value));
    }

    @Test
    public void testSetShort() throws Exception {

        // given
        final int position = 0;
        final short value = 0;

        // then
        verifyMethodCall(q -> q.setShort(position, value));
    }

    @Test
    public void testSetInteger() throws Exception {

        // given
        final int position = 0;
        final int value = 0;

        // then
        verifyMethodCall(q -> q.setInteger(position, value));
    }

    @Test
    public void testSetLong() throws Exception {

        // given
        final int position = 0;
        final long value = 0;

        // then
        verifyMethodCall(q -> q.setLong(position, value));
    }

    @Test
    public void testSetFloat() throws Exception {

        // given
        final int position = 0;
        final float value = 0f;

        // then
        verifyMethodCall(q -> q.setFloat(position, value));
    }

    @Test
    public void testSetDouble() throws Exception {

        // given
        final int position = 0;
        final double value = 0d;

        // then
        verifyMethodCall(q -> q.setDouble(position, value));
    }

    @Test
    public void testSetBinary() throws Exception {

        // given
        final int position = 0;
        final byte[] value = new byte[0];

        // then
        verifyMethodCall(q -> q.setBinary(position, value));
    }

    @Test
    public void testSetText() throws Exception {

        // given
        final int position = 0;
        final String value = "value";

        // then
        verifyMethodCall(q -> q.setText(position, value));
    }

    @Test
    public void testSetSerializable() throws Exception {

        // given
        final int position = 0;
        final String value = "value";

        // then
        verifyMethodCall(q -> q.setSerializable(position, value));
    }

    @Test
    public void testSetLocale() throws Exception {

        // given
        final int position = 0;
        final Locale value = new Locale("en");

        // then
        verifyMethodCall(q -> q.setLocale(position, value));
    }

    @Test
    public void testSetBigDecimal() throws Exception {

        // given
        final int position = 0;
        final BigDecimal value = BigDecimal.TEN;

        // then
        verifyMethodCall(q -> q.setBigDecimal(position, value));
    }

    @Test
    public void testSetBigInteger() throws Exception {

        // given
        final int position = 0;
        final BigInteger value = BigInteger.TEN;

        // then
        verifyMethodCall(q -> q.setBigInteger(position, value));
    }

    @Test
    public void testSetDate() throws Exception {

        // given
        final int position = 0;
        final Date value = new Date();

        // then
        verifyMethodCall(q -> q.setDate(position, value));
    }

    @Test
    public void testSetTime() throws Exception {

        // given
        final int position = 0;
        final Date value = new Date();

        // then
        verifyMethodCall(q -> q.setTime(position, value));
    }

    @Test
    public void testSetTimestamp() throws Exception {

        // given
        final int position = 0;
        final Date value = new Date();

        // then
        verifyMethodCall(q -> q.setTimestamp(position, value));
    }

    @Test
    public void testSetCalendar() throws Exception {

        // given
        final int position = 0;
        final Calendar value = Calendar.getInstance();

        // then
        verifyMethodCall(q -> q.setCalendar(position, value));
    }

    @Test
    public void testSetCalendarDate() throws Exception {

        // given
        final int position = 0;
        final Calendar value = Calendar.getInstance();

        // then
        verifyMethodCall(q -> q.setCalendarDate(position, value));
    }

    @Test
    public void testSetString1() throws Exception {

        // given
        final String name = "name";
        final String value = "value";

        // then
        verifyMethodCall(q -> q.setString(name, value));
    }

    @Test
    public void testSetCharacter1() throws Exception {

        // given
        final String name = "name";
        final char value = 'c';

        // then
        verifyMethodCall(q -> q.setCharacter(name, value));
    }

    @Test
    public void testSetBoolean1() throws Exception {

        // given
        final String name = "name";
        final boolean value = true;

        // then
        verifyMethodCall(q -> q.setBoolean(name, value));
    }

    @Test
    public void testSetByte1() throws Exception {

        // given
        final String name = "name";
        final byte value = 0;

        // then
        verifyMethodCall(q -> q.setByte(name, value));
    }

    @Test
    public void testSetShort1() throws Exception {

        // given
        final String name = "name";
        final short value = 0;

        // then
        verifyMethodCall(q -> q.setShort(name, value));
    }

    @Test
    public void testSetInteger1() throws Exception {

        // given
        final String name = "name";
        final int value = 0;

        // then
        verifyMethodCall(q -> q.setInteger(name, value));
    }

    @Test
    public void testSetLong1() throws Exception {

        // given
        final String name = "name";
        final long value = 0;

        // then
        verifyMethodCall(q -> q.setLong(name, value));
    }

    @Test
    public void testSetFloat1() throws Exception {

        // given
        final String name = "name";
        final float value = 0;

        // then
        verifyMethodCall(q -> q.setFloat(name, value));
    }

    @Test
    public void testSetDouble1() throws Exception {

        // given
        final String name = "name";
        final double value = 0d;

        // then
        verifyMethodCall(q -> q.setDouble(name, value));
    }

    @Test
    public void testSetBinary1() throws Exception {

        // given
        final String name = "name";
        final byte[] value = new byte[0];

        // then
        verifyMethodCall(q -> q.setBinary(name, value));
    }

    @Test
    public void testSetText1() throws Exception {

        // given
        final String name = "name";
        final String value = "value";

        // then
        verifyMethodCall(q -> q.setText(name, value));
    }

    @Test
    public void testSetSerializable1() throws Exception {

        // given
        final String name = "name";
        final String value = "value";

        // then
        verifyMethodCall(q -> q.setSerializable(name, value));
    }

    @Test
    public void testSetLocale1() throws Exception {

        // given
        final String name = "name";
        final Locale value = new Locale("en");

        // then
        verifyMethodCall(q -> q.setLocale(name, value));
    }

    @Test
    public void testSetBigInteger1() throws Exception {

        // given
        final String name = "name";
        final BigInteger value = BigInteger.TEN;

        // then
        verifyMethodCall(q -> q.setBigInteger(name, value));
    }

    @Test
    public void testSetBigDecimal1() throws Exception {

        // given
        final String name = "name";
        final BigDecimal value = BigDecimal.TEN;

        // then
        verifyMethodCall(q -> q.setBigDecimal(name, value));
    }

    @Test
    public void testSetDate1() throws Exception {

        // given
        final String name = "name";
        final Date value = new Date();

        // then
        verifyMethodCall(q -> q.setDate(name, value));
    }

    @Test
    public void testSetTime1() throws Exception {

        // given
        final String name = "name";
        final Date value = new Date();

        // then
        verifyMethodCall(q -> q.setTime(name, value));
    }

    @Test
    public void testSetTimestamp1() throws Exception {

        // given
        final String name = "name";
        final Date value = new Date();

        // then
        verifyMethodCall(q -> q.setTimestamp(name, value));
    }

    @Test
    public void testSetCalendar1() throws Exception {

        // given
        final String name = "name";
        final Calendar value = Calendar.getInstance();

        // then
        verifyMethodCall(q -> q.setCalendar(name, value));
    }

    @Test
    public void testSetCalendarDate1() throws Exception {

        // given
        final String name = "name";
        final Calendar value = Calendar.getInstance();

        // then
        verifyMethodCall(q -> q.setCalendar(name, value));
    }

    @Test
    public void testSetEntity() throws Exception {

        // given
        final int position = 0;
        final Object value = new Object();

        // then
        verifyMethodCall(q -> q.setEntity(position, value));
    }

    @Test
    public void testSetEntity1() throws Exception {

        // given
        final String name = "name";
        final Object value = new Object();

        // then
        verifyMethodCall(q -> q.setEntity(name, value));
    }

    @Test
    public void testSetResultTransformer() throws Exception {

        // given
        final ResultTransformer resultTransformer = mock(ResultTransformer.class);

        // then
        verifyMethodCall(q -> q.setResultTransformer(resultTransformer));
    }
}