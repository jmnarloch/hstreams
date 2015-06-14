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

import com.github.jmnarloch.hstreams.StreamSQLQuery;
import org.hibernate.*;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

/**
 * The {@link SQLQuery} decorator.
 *
 * @author Jakub Narloch
 */
class SQLQueryDelegate<T extends StreamSQLQuery<T>> extends BaseQueryDelegate<SQLQuery> implements StreamSQLQuery<T> {

    SQLQueryDelegate(SQLQuery delegate) {
        super(delegate);
    }

    @Override
    public Stream<?> stream() {
        return list().stream();
    }

    @Override
    public Stream<?> parallelStream() {
        return list().parallelStream();
    }

    @Override
    public Optional<?> optionalResult() {
        return Optional.ofNullable(uniqueResult());
    }

    @Override
    public Collection<String> getSynchronizedQuerySpaces() {
        return delegate().getSynchronizedQuerySpaces();
    }

    @Override
    public T addSynchronizedQuerySpace(String querySpace) {
        return wrap(delegate().addSynchronizedQuerySpace(querySpace));
    }

    @Override
    public T addSynchronizedEntityName(String entityName) throws MappingException {
        return wrap(delegate().addSynchronizedQuerySpace(entityName));
    }

    @Override
    public T addSynchronizedEntityClass(Class entityClass) throws MappingException {
        return wrap(delegate().addSynchronizedEntityClass(entityClass));
    }

    @Override
    public T setResultSetMapping(String name) {
        return wrap(delegate().setResultSetMapping(name));
    }

    @Override
    public boolean isCallable() {
        return delegate().isCallable();
    }

    @Override
    public List<NativeSQLQueryReturn> getQueryReturns() {
        return delegate().getQueryReturns();
    }

    @Override
    public T addScalar(String columnAlias) {
        return wrap(delegate().addScalar(columnAlias));
    }

    @Override
    public T addScalar(String columnAlias, Type type) {
        return wrap(delegate().addScalar(columnAlias, type));
    }

    @Override
    public RootReturn addRoot(String tableAlias, String entityName) {
        return delegate().addRoot(tableAlias, entityName);
    }

    @Override
    public RootReturn addRoot(String tableAlias, Class entityType) {
        return delegate().addRoot(tableAlias, entityType);
    }

    @Override
    public T addEntity(String entityName) {
        return wrap(delegate().addEntity(entityName));
    }

    @Override
    public T addEntity(String tableAlias, String entityName) {
        return wrap(delegate().addEntity(tableAlias, entityName));
    }

    @Override
    public T addEntity(String tableAlias, String entityName, LockMode lockMode) {
        return wrap(delegate().addEntity(tableAlias, entityName, lockMode));
    }

    @Override
    public T addEntity(Class entityType) {
        return wrap(delegate().addEntity(entityType));
    }

    @Override
    public T addEntity(String tableAlias, Class entityType) {
        return wrap(delegate().addEntity(tableAlias, entityType));
    }

    @Override
    public T addEntity(String tableAlias, Class entityName, LockMode lockMode) {
        return wrap(delegate().addEntity(tableAlias, entityName, lockMode));
    }

    @Override
    public FetchReturn addFetch(String tableAlias, String ownerTableAlias, String joinPropertyName) {
        return delegate().addFetch(tableAlias, ownerTableAlias, joinPropertyName);
    }

    @Override
    public T addJoin(String tableAlias, String path) {
        return wrap(delegate().addJoin(tableAlias, path));
    }

    @Override
    public T addJoin(String tableAlias, String ownerTableAlias, String joinPropertyName) {
        return wrap(delegate().addJoin(tableAlias, ownerTableAlias, joinPropertyName));
    }

    @Override
    public T addJoin(String tableAlias, String path, LockMode lockMode) {
        return wrap(delegate().addJoin(tableAlias, path, lockMode));
    }

    @Override
    public String getQueryString() {
        return delegate().getQueryString();
    }

    @Override
    public Integer getMaxResults() {
        return delegate().getMaxResults();
    }

    @Override
    public T setMaxResults(int maxResults) {
        return wrap(delegate().setMaxResults(maxResults));
    }

    @Override
    public Integer getFirstResult() {
        return delegate().getFirstResult();
    }

    @Override
    public T setFirstResult(int firstResult) {
        return wrap(delegate().setFirstResult(firstResult));
    }

    @Override
    public T setFlushMode(FlushMode flushMode) {
        return wrap(delegate().setFlushMode(flushMode));
    }

    @Override
    public T setCacheMode(CacheMode cacheMode) {
        return wrap(delegate().setCacheMode(cacheMode));
    }

    @Override
    public T setCacheable(boolean cacheable) {
        return wrap(delegate().setCacheable(cacheable));
    }

    @Override
    public T setCacheRegion(String cacheRegion) {
        return wrap(delegate().setCacheRegion(cacheRegion));
    }

    @Override
    public T setTimeout(int timeout) {
        return wrap(delegate().setTimeout(timeout));
    }

    @Override
    public T setFetchSize(int fetchSize) {
        return wrap(delegate().setFetchSize(fetchSize));
    }

    @Override
    public T setReadOnly(boolean readOnly) {
        return wrap(delegate().setReadOnly(readOnly));
    }

    @Override
    public LockOptions getLockOptions() {
        return delegate().getLockOptions();
    }

    @Override
    public T setLockOptions(LockOptions lockOptions) {
        return wrap(delegate().setLockOptions(lockOptions));
    }

    @Override
    public T setLockMode(String alias, LockMode lockMode) {
        return wrap(delegate().setLockMode(alias, lockMode));
    }

    @Override
    public String getComment() {
        return delegate().getComment();
    }

    @Override
    public T setComment(String comment) {
        return wrap(delegate().setComment(comment));
    }

    @Override
    public T addQueryHint(String hint) {
        return wrap(delegate().addQueryHint(hint));
    }

    @Override
    public String[] getReturnAliases() {
        return delegate().getReturnAliases();
    }

    @Override
    public String[] getNamedParameters() {
        return delegate().getNamedParameters();
    }

    @Override
    public Iterator iterate() {
        return delegate().iterate();
    }

    @Override
    public ScrollableResults scroll() {
        return delegate().scroll();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) {
        return delegate().scroll(scrollMode);
    }

    @Override
    public List list() {
        return delegate().list();
    }

    @Override
    public Object uniqueResult() {
        return delegate().uniqueResult();
    }

    @Override
    public int executeUpdate() {
        return delegate().executeUpdate();
    }

    @Override
    public T setParameter(int position, Object val, Type type) {
        return wrap(delegate().setParameter(position, val, type));
    }

    @Override
    public T setParameter(String name, Object val, Type type) {
        return wrap(delegate().setParameter(name, val, type));
    }

    @Override
    public T setParameter(int position, Object val) {
        return wrap(delegate().setParameter(position, val));
    }

    @Override
    public T setParameter(String name, Object val) {
        return wrap(delegate().setParameter(name, val));
    }

    @Override
    public T setParameters(Object[] values, Type[] types) {
        return wrap(delegate().setParameters(values, types));
    }

    @Override
    public T setParameterList(String name, Collection values, Type type) {
        return wrap(delegate().setParameterList(name, values, type));
    }

    @Override
    public T setParameterList(String name, Collection values) {
        return wrap(delegate().setParameterList(name, values));
    }

    @Override
    public T setParameterList(String name, Object[] values, Type type) {
        return wrap(delegate().setParameterList(name, values, type));
    }

    @Override
    public T setParameterList(String name, Object[] values) {
        return wrap(delegate().setParameterList(name, values));
    }

    @Override
    public T setProperties(Object bean) {
        return wrap(delegate().setProperties(bean));
    }

    @Override
    public T setProperties(Map bean) {
        return wrap(delegate().setProperties(bean));
    }

    @Override
    public T setString(int position, String val) {
        return wrap(delegate().setString(position, val));
    }

    @Override
    public T setCharacter(int position, char val) {
        return wrap(delegate().setCharacter(position, val));
    }

    @Override
    public T setBoolean(int position, boolean val) {
        return wrap(delegate().setBoolean(position, val));
    }

    @Override
    public T setByte(int position, byte val) {
        return wrap(delegate().setByte(position, val));
    }

    @Override
    public T setShort(int position, short val) {
        return wrap(delegate().setShort(position, val));
    }

    @Override
    public T setInteger(int position, int val) {
        return wrap(delegate().setInteger(position, val));
    }

    @Override
    public T setLong(int position, long val) {
        return wrap(delegate().setLong(position, val));
    }

    @Override
    public T setFloat(int position, float val) {
        return wrap(delegate().setFloat(position, val));
    }

    @Override
    public T setDouble(int position, double val) {
        return wrap(delegate().setDouble(position, val));
    }

    @Override
    public T setBinary(int position, byte[] val) {
        return wrap(delegate().setBinary(position, val));
    }

    @Override
    public T setText(int position, String val) {
        return wrap(delegate().setText(position, val));
    }

    @Override
    public T setSerializable(int position, Serializable val) {
        return wrap(delegate().setSerializable(position, val));
    }

    @Override
    public T setLocale(int position, Locale locale) {
        return wrap(delegate().setLocale(position, locale));
    }

    @Override
    public T setBigDecimal(int position, BigDecimal number) {
        return wrap(delegate().setBigDecimal(position, number));
    }

    @Override
    public T setBigInteger(int position, BigInteger number) {
        return wrap(delegate().setBigInteger(position, number));
    }

    @Override
    public T setDate(int position, Date date) {
        return wrap(delegate().setDate(position, date));
    }

    @Override
    public T setTime(int position, Date date) {
        return wrap(delegate().setTime(position, date));
    }

    @Override
    public T setTimestamp(int position, Date date) {
        return wrap(delegate().setTimestamp(position, date));
    }

    @Override
    public T setCalendar(int position, Calendar calendar) {
        return wrap(delegate().setCalendar(position, calendar));
    }

    @Override
    public T setCalendarDate(int position, Calendar calendar) {
        return wrap(delegate().setCalendarDate(position, calendar));
    }

    @Override
    public T setString(String name, String val) {
        return wrap(delegate().setString(name, val));
    }

    @Override
    public T setCharacter(String name, char val) {
        return wrap(delegate().setCharacter(name, val));
    }

    @Override
    public T setBoolean(String name, boolean val) {
        return wrap(delegate().setBoolean(name, val));
    }

    @Override
    public T setByte(String name, byte val) {
        return wrap(delegate().setByte(name, val));
    }

    @Override
    public T setShort(String name, short val) {
        return wrap(delegate().setShort(name, val));
    }

    @Override
    public T setInteger(String name, int val) {
        return wrap(delegate().setInteger(name, val));
    }

    @Override
    public T setLong(String name, long val) {
        return wrap(delegate().setLong(name, val));
    }

    @Override
    public T setFloat(String name, float val) {
        return wrap(delegate().setFloat(name, val));
    }

    @Override
    public T setDouble(String name, double val) {
        return wrap(delegate().setDouble(name, val));
    }

    @Override
    public T setBinary(String name, byte[] val) {
        return wrap(delegate().setBinary(name, val));
    }

    @Override
    public T setText(String name, String val) {
        return wrap(delegate().setText(name, val));
    }

    @Override
    public T setSerializable(String name, Serializable val) {
        return wrap(delegate().setSerializable(name, val));
    }

    @Override
    public T setLocale(String name, Locale locale) {
        return wrap(delegate().setLocale(name, locale));
    }

    @Override
    public T setBigDecimal(String name, BigDecimal number) {
        return wrap(delegate().setBigDecimal(name, number));
    }

    @Override
    public T setBigInteger(String name, BigInteger number) {
        return wrap(delegate().setBigInteger(name, number));
    }

    @Override
    public T setDate(String name, Date date) {
        return wrap(delegate().setDate(name, date));
    }

    @Override
    public T setTime(String name, Date date) {
        return wrap(delegate().setTime(name, date));
    }

    @Override
    public T setTimestamp(String name, Date date) {
        return wrap(delegate().setTimestamp(name, date));
    }

    @Override
    public T setCalendar(String name, Calendar calendar) {
        return wrap(delegate().setCalendar(name, calendar));
    }

    @Override
    public T setCalendarDate(String name, Calendar calendar) {
        return wrap(delegate().setCalendarDate(name, calendar));
    }

    @Override
    public T setEntity(int position, Object val) {
        return wrap(delegate().setEntity(position, val));
    }

    @Override
    public T setEntity(String name, Object val) {
        return wrap(delegate().setEntity(name, val));
    }

    @Override
    public T setResultTransformer(ResultTransformer transformer) {
        return wrap(delegate().setResultTransformer(transformer));
    }

    @SuppressWarnings("unchecked")
    private T wrap(final Query query) {
        return (T) this;
    }
}
