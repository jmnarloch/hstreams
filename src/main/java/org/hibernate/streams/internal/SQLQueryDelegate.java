package org.hibernate.streams.internal;

import org.hibernate.*;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;
import org.hibernate.streams.StreamSQLQuery;
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
class SQLQueryDelegate implements StreamSQLQuery {

    private final SQLQuery delegate;

    SQLQueryDelegate(SQLQuery delegate) {
        this.delegate = delegate;
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
        return delegate.getSynchronizedQuerySpaces();
    }

    @Override
    public StreamSQLQuery addSynchronizedQuerySpace(String querySpace) {
        return wrap(delegate.addSynchronizedQuerySpace(querySpace));
    }

    @Override
    public StreamSQLQuery addSynchronizedEntityName(String entityName) throws MappingException {
        return wrap(delegate.addSynchronizedQuerySpace(entityName));
    }

    @Override
    public StreamSQLQuery addSynchronizedEntityClass(Class entityClass) throws MappingException {
        return wrap(delegate.addSynchronizedEntityClass(entityClass));
    }

    @Override
    public StreamSQLQuery setResultSetMapping(String name) {
        return wrap(delegate.setResultSetMapping(name));
    }

    @Override
    public boolean isCallable() {
        return delegate.isCallable();
    }

    @Override
    public List<NativeSQLQueryReturn> getQueryReturns() {
        return delegate.getQueryReturns();
    }

    @Override
    public StreamSQLQuery addScalar(String columnAlias) {
        return wrap(delegate.addScalar(columnAlias));
    }

    @Override
    public StreamSQLQuery addScalar(String columnAlias, Type type) {
        return wrap(delegate.addScalar(columnAlias, type));
    }

    @Override
    public RootReturn addRoot(String tableAlias, String entityName) {
        return delegate.addRoot(tableAlias, entityName);
    }

    @Override
    public RootReturn addRoot(String tableAlias, Class entityType) {
        return delegate.addRoot(tableAlias, entityType);
    }

    @Override
    public StreamSQLQuery addEntity(String entityName) {
        return wrap(delegate.addEntity(entityName));
    }

    @Override
    public StreamSQLQuery addEntity(String tableAlias, String entityName) {
        return wrap(delegate.addEntity(tableAlias, entityName));
    }

    @Override
    public StreamSQLQuery addEntity(String tableAlias, String entityName, LockMode lockMode) {
        return wrap(delegate.addEntity(tableAlias, entityName, lockMode));
    }

    @Override
    public StreamSQLQuery addEntity(Class entityType) {
        return wrap(delegate.addEntity(entityType));
    }

    @Override
    public StreamSQLQuery addEntity(String tableAlias, Class entityType) {
        return wrap(delegate.addEntity(tableAlias, entityType));
    }

    @Override
    public StreamSQLQuery addEntity(String tableAlias, Class entityName, LockMode lockMode) {
        return wrap(delegate.addEntity(tableAlias, entityName, lockMode));
    }

    @Override
    public FetchReturn addFetch(String tableAlias, String ownerTableAlias, String joinPropertyName) {
        return delegate.addFetch(tableAlias, ownerTableAlias, joinPropertyName);
    }

    @Override
    public StreamSQLQuery addJoin(String tableAlias, String path) {
        return wrap(delegate.addJoin(tableAlias, path));
    }

    @Override
    public StreamSQLQuery addJoin(String tableAlias, String ownerTableAlias, String joinPropertyName) {
        return wrap(delegate.addJoin(tableAlias, ownerTableAlias, joinPropertyName));
    }

    @Override
    public StreamSQLQuery addJoin(String tableAlias, String path, LockMode lockMode) {
        return wrap(delegate.addJoin(tableAlias, path, lockMode));
    }

    @Override
    public String getQueryString() {
        return delegate.getQueryString();
    }

    @Override
    public Integer getMaxResults() {
        return delegate.getMaxResults();
    }

    @Override
    public StreamSQLQuery setMaxResults(int maxResults) {
        return wrap(delegate.setMaxResults(maxResults));
    }

    @Override
    public Integer getFirstResult() {
        return delegate.getFirstResult();
    }

    @Override
    public StreamSQLQuery setFirstResult(int firstResult) {
        return wrap(delegate.setFirstResult(firstResult));
    }

    @Override
    public FlushMode getFlushMode() {
        return delegate.getFlushMode();
    }

    @Override
    public StreamSQLQuery setFlushMode(FlushMode flushMode) {
        return wrap(delegate.setFlushMode(flushMode));
    }

    @Override
    public CacheMode getCacheMode() {
        return delegate.getCacheMode();
    }

    @Override
    public StreamSQLQuery setCacheMode(CacheMode cacheMode) {
        return wrap(delegate.setCacheMode(cacheMode));
    }

    @Override
    public boolean isCacheable() {
        return delegate.isCacheable();
    }

    @Override
    public StreamSQLQuery setCacheable(boolean cacheable) {
        return wrap(delegate.setCacheable(cacheable));
    }

    @Override
    public String getCacheRegion() {
        return delegate.getCacheRegion();
    }

    @Override
    public StreamSQLQuery setCacheRegion(String cacheRegion) {
        return wrap(delegate.setCacheRegion(cacheRegion));
    }

    @Override
    public Integer getTimeout() {
        return delegate.getTimeout();
    }

    @Override
    public StreamSQLQuery setTimeout(int timeout) {
        return wrap(delegate.setTimeout(timeout));
    }

    @Override
    public Integer getFetchSize() {
        return delegate.getFetchSize();
    }

    @Override
    public StreamSQLQuery setFetchSize(int fetchSize) {
        return wrap(delegate.setFetchSize(fetchSize));
    }

    @Override
    public boolean isReadOnly() {
        return delegate.isReadOnly();
    }

    @Override
    public StreamSQLQuery setReadOnly(boolean readOnly) {
        return wrap(delegate.setReadOnly(readOnly));
    }

    @Override
    public Type[] getReturnTypes() {
        return delegate.getReturnTypes();
    }

    @Override
    public LockOptions getLockOptions() {
        return delegate.getLockOptions();
    }

    @Override
    public StreamSQLQuery setLockOptions(LockOptions lockOptions) {
        return wrap(delegate.setLockOptions(lockOptions));
    }

    @Override
    public StreamSQLQuery setLockMode(String alias, LockMode lockMode) {
        return wrap(delegate.setLockMode(alias, lockMode));
    }

    @Override
    public String getComment() {
        return delegate.getComment();
    }

    @Override
    public StreamSQLQuery setComment(String comment) {
        return wrap(delegate.setComment(comment));
    }

    @Override
    public StreamSQLQuery addQueryHint(String hint) {
        return wrap(delegate.addQueryHint(hint));
    }

    @Override
    public String[] getReturnAliases() {
        return delegate.getReturnAliases();
    }

    @Override
    public String[] getNamedParameters() {
        return delegate.getNamedParameters();
    }

    @Override
    public Iterator iterate() {
        return delegate.iterate();
    }

    @Override
    public ScrollableResults scroll() {
        return delegate.scroll();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) {
        return delegate.scroll(scrollMode);
    }

    @Override
    public List list() {
        return delegate.list();
    }

    @Override
    public Object uniqueResult() {
        return delegate.uniqueResult();
    }

    @Override
    public int executeUpdate() {
        return delegate.executeUpdate();
    }

    @Override
    public StreamSQLQuery setParameter(int position, Object val, Type type) {
        return wrap(delegate.setParameter(position, val, type));
    }

    @Override
    public StreamSQLQuery setParameter(String name, Object val, Type type) {
        return wrap(delegate.setParameter(name, val, type));
    }

    @Override
    public StreamSQLQuery setParameter(int position, Object val) {
        return wrap(delegate.setParameter(position, val));
    }

    @Override
    public StreamSQLQuery setParameter(String name, Object val) {
        return wrap(delegate.setParameter(name, val));
    }

    @Override
    public StreamSQLQuery setParameters(Object[] values, Type[] types) {
        return wrap(delegate.setParameters(values, types));
    }

    @Override
    public StreamSQLQuery setParameterList(String name, Collection values, Type type) {
        return wrap(delegate.setParameterList(name, values, type));
    }

    @Override
    public StreamSQLQuery setParameterList(String name, Collection values) {
        return wrap(delegate.setParameterList(name, values));
    }

    @Override
    public StreamSQLQuery setParameterList(String name, Object[] values, Type type) {
        return wrap(delegate.setParameterList(name, values, type));
    }

    @Override
    public StreamSQLQuery setParameterList(String name, Object[] values) {
        return wrap(delegate.setParameterList(name, values));
    }

    @Override
    public StreamSQLQuery setProperties(Object bean) {
        return wrap(delegate.setProperties(bean));
    }

    @Override
    public StreamSQLQuery setProperties(Map bean) {
        return wrap(delegate.setProperties(bean));
    }

    @Override
    public StreamSQLQuery setString(int position, String val) {
        return wrap(delegate.setString(position, val));
    }

    @Override
    public StreamSQLQuery setCharacter(int position, char val) {
        return wrap(delegate.setCharacter(position, val));
    }

    @Override
    public StreamSQLQuery setBoolean(int position, boolean val) {
        return wrap(delegate.setBoolean(position, val));
    }

    @Override
    public StreamSQLQuery setByte(int position, byte val) {
        return wrap(delegate.setByte(position, val));
    }

    @Override
    public StreamSQLQuery setShort(int position, short val) {
        return wrap(delegate.setShort(position, val));
    }

    @Override
    public StreamSQLQuery setInteger(int position, int val) {
        return wrap(delegate.setInteger(position, val));
    }

    @Override
    public StreamSQLQuery setLong(int position, long val) {
        return wrap(delegate.setLong(position, val));
    }

    @Override
    public StreamSQLQuery setFloat(int position, float val) {
        return wrap(delegate.setFloat(position, val));
    }

    @Override
    public StreamSQLQuery setDouble(int position, double val) {
        return wrap(delegate.setDouble(position, val));
    }

    @Override
    public StreamSQLQuery setBinary(int position, byte[] val) {
        return wrap(delegate.setBinary(position, val));
    }

    @Override
    public StreamSQLQuery setText(int position, String val) {
        return wrap(delegate.setText(position, val));
    }

    @Override
    public StreamSQLQuery setSerializable(int position, Serializable val) {
        return wrap(delegate.setSerializable(position, val));
    }

    @Override
    public StreamSQLQuery setLocale(int position, Locale locale) {
        return wrap(delegate.setLocale(position, locale));
    }

    @Override
    public StreamSQLQuery setBigDecimal(int position, BigDecimal number) {
        return wrap(delegate.setBigDecimal(position, number));
    }

    @Override
    public StreamSQLQuery setBigInteger(int position, BigInteger number) {
        return wrap(delegate.setBigInteger(position, number));
    }

    @Override
    public StreamSQLQuery setDate(int position, Date date) {
        return wrap(delegate.setDate(position, date));
    }

    @Override
    public StreamSQLQuery setTime(int position, Date date) {
        return wrap(delegate.setTime(position, date));
    }

    @Override
    public StreamSQLQuery setTimestamp(int position, Date date) {
        return wrap(delegate.setTimestamp(position, date));
    }

    @Override
    public StreamSQLQuery setCalendar(int position, Calendar calendar) {
        return wrap(delegate.setCalendar(position, calendar));
    }

    @Override
    public StreamSQLQuery setCalendarDate(int position, Calendar calendar) {
        return wrap(delegate.setCalendarDate(position, calendar));
    }

    @Override
    public StreamSQLQuery setString(String name, String val) {
        return wrap(delegate.setSerializable(name, val));
    }

    @Override
    public StreamSQLQuery setCharacter(String name, char val) {
        return wrap(delegate.setCharacter(name, val));
    }

    @Override
    public StreamSQLQuery setBoolean(String name, boolean val) {
        return wrap(delegate.setBoolean(name, val));
    }

    @Override
    public StreamSQLQuery setByte(String name, byte val) {
        return wrap(delegate.setByte(name, val));
    }

    @Override
    public StreamSQLQuery setShort(String name, short val) {
        return wrap(delegate.setShort(name, val));
    }

    @Override
    public StreamSQLQuery setInteger(String name, int val) {
        return wrap(delegate.setInteger(name, val));
    }

    @Override
    public StreamSQLQuery setLong(String name, long val) {
        return wrap(delegate.setLong(name, val));
    }

    @Override
    public StreamSQLQuery setFloat(String name, float val) {
        return wrap(delegate.setFloat(name, val));
    }

    @Override
    public StreamSQLQuery setDouble(String name, double val) {
        return wrap(delegate.setDouble(name, val));
    }

    @Override
    public StreamSQLQuery setBinary(String name, byte[] val) {
        return wrap(delegate.setBinary(name, val));
    }

    @Override
    public StreamSQLQuery setText(String name, String val) {
        return wrap(delegate.setText(name, val));
    }

    @Override
    public StreamSQLQuery setSerializable(String name, Serializable val) {
        return wrap(delegate.setSerializable(name, val));
    }

    @Override
    public StreamSQLQuery setLocale(String name, Locale locale) {
        return wrap(delegate.setLocale(name, locale));
    }

    @Override
    public StreamSQLQuery setBigDecimal(String name, BigDecimal number) {
        return wrap(delegate.setBigDecimal(name, number));
    }

    @Override
    public StreamSQLQuery setBigInteger(String name, BigInteger number) {
        return wrap(delegate.setBigInteger(name, number));
    }

    @Override
    public StreamSQLQuery setDate(String name, Date date) {
        return wrap(delegate.setDate(name, date));
    }

    @Override
    public StreamSQLQuery setTime(String name, Date date) {
        return wrap(delegate.setTime(name, date));
    }

    @Override
    public StreamSQLQuery setTimestamp(String name, Date date) {
        return wrap(delegate.setTimestamp(name, date));
    }

    @Override
    public StreamSQLQuery setCalendar(String name, Calendar calendar) {
        return wrap(delegate.setCalendar(name, calendar));
    }

    @Override
    public StreamSQLQuery setCalendarDate(String name, Calendar calendar) {
        return wrap(delegate.setCalendarDate(name, calendar));
    }

    @Override
    public StreamSQLQuery setEntity(int position, Object val) {
        return wrap(delegate.setEntity(position, val));
    }

    @Override
    public StreamSQLQuery setEntity(String name, Object val) {
        return wrap(delegate.setEntity(name, val));
    }

    @Override
    public StreamSQLQuery setResultTransformer(ResultTransformer transformer) {
        return wrap(delegate.setResultTransformer(transformer));
    }

    private StreamSQLQuery wrap(final Query query) {
        return this;
    }
}
