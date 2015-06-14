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
package com.github.jmnarloch.hstreams;

import org.hibernate.*;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * A wrapper around the {@link SQLQuery} interface that overrides most of the methods return types.
 *
 * @param <T> the actual SQL query type
 * @author Jakub Narloch
 */
public interface StreamSQLQuery<T extends StreamSQLQuery<T>> extends SQLQuery, BaseStreamQuery {

    @Override
    T addSynchronizedQuerySpace(String querySpace);

    @Override
    T addSynchronizedEntityName(String entityName) throws MappingException;

    @Override
    T addSynchronizedEntityClass(Class entityClass) throws MappingException;

    @Override
    T setResultSetMapping(String name);

    @Override
    T addScalar(String columnAlias);

    @Override
    T addScalar(String columnAlias, Type type);

    @Override
    T addEntity(String entityName);

    @Override
    T addEntity(String tableAlias, String entityName);

    @Override
    T addEntity(String tableAlias, String entityName, LockMode lockMode);

    @Override
    T addEntity(Class entityType);

    @Override
    T addEntity(String tableAlias, Class entityType);

    @Override
    T addEntity(String tableAlias, Class entityName, LockMode lockMode);

    @Override
    T addJoin(String tableAlias, String path);

    @Override
    T addJoin(String tableAlias, String ownerTableAlias, String joinPropertyName);

    @Override
    T addJoin(String tableAlias, String path, LockMode lockMode);

    @Override
    T setMaxResults(int maxResults);

    @Override
    T setFirstResult(int firstResult);

    @Override
    T setFlushMode(FlushMode flushMode);

    @Override
    T setCacheMode(CacheMode cacheMode);

    @Override
    T setCacheable(boolean cacheable);

    @Override
    T setCacheRegion(String cacheRegion);

    @Override
    T setTimeout(int timeout);

    @Override
    T setFetchSize(int fetchSize);

    @Override
    T setReadOnly(boolean readOnly);

    @Override
    T setLockOptions(LockOptions lockOptions);

    @Override
    T setLockMode(String alias, LockMode lockMode);

    @Override
    T setComment(String comment);

    @Override
    T addQueryHint(String hint);

    @Override
    T setParameter(int position, Object val, Type type);

    @Override
    T setParameter(String name, Object val, Type type);

    @Override
    T setParameter(int position, Object val);

    @Override
    T setParameter(String name, Object val);

    @Override
    T setParameters(Object[] values, Type[] types);

    @Override
    T setParameterList(String name, Collection values, Type type);

    @Override
    T setParameterList(String name, Object[] values, Type type);

    @Override
    T setParameterList(String name, Collection values);

    @Override
    T setParameterList(String name, Object[] values);

    @Override
    T setProperties(Object bean);

    @Override
    T setProperties(Map bean);

    @Override
    T setString(int position, String val);

    @Override
    T setCharacter(int position, char val);

    @Override
    T setBoolean(int position, boolean val);

    @Override
    T setByte(int position, byte val);

    @Override
    T setShort(int position, short val);

    @Override
    T setInteger(int position, int val);

    @Override
    T setLong(int position, long val);

    @Override
    T setFloat(int position, float val);

    @Override
    T setDouble(int position, double val);

    @Override
    T setBinary(int position, byte[] val);

    @Override
    T setText(int position, String val);

    @Override
    T setSerializable(int position, Serializable val);

    @Override
    T setBigDecimal(int position, BigDecimal number);

    @Override
    T setLocale(int position, Locale locale);

    @Override
    T setBigInteger(int position, BigInteger number);

    @Override
    T setDate(int position, Date date);

    @Override
    T setTime(int position, Date date);

    @Override
    T setTimestamp(int position, Date date);

    @Override
    T setCalendarDate(int position, Calendar calendar);

    @Override
    T setCalendar(int position, Calendar calendar);

    @Override
    T setString(String name, String val);

    @Override
    T setCharacter(String name, char val);

    @Override
    T setBoolean(String name, boolean val);

    @Override
    T setByte(String name, byte val);

    @Override
    T setShort(String name, short val);

    @Override
    T setInteger(String name, int val);

    @Override
    T setLong(String name, long val);

    @Override
    T setFloat(String name, float val);

    @Override
    T setDouble(String name, double val);

    @Override
    T setBinary(String name, byte[] val);

    @Override
    T setSerializable(String name, Serializable val);

    @Override
    T setText(String name, String val);

    @Override
    T setLocale(String name, Locale locale);

    @Override
    T setBigDecimal(String name, BigDecimal number);

    @Override
    T setBigInteger(String name, BigInteger number);

    @Override
    T setDate(String name, Date date);

    @Override
    T setTimestamp(String name, Date date);

    @Override
    T setTime(String name, Date date);

    @Override
    T setCalendar(String name, Calendar calendar);

    @Override
    T setCalendarDate(String name, Calendar calendar);

    @Override
    T setEntity(int position, Object val);

    @Override
    T setEntity(String name, Object val);

    @Override
    T setResultTransformer(ResultTransformer transformer);
}
