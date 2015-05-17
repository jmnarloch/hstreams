package org.hibernate.streams.internal;

import org.hibernate.*;
import org.hibernate.streams.StreamQuery;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

/**
 * The {@link Query} decorator.
 *
 * @author Jakub Narloch
 */
class QueryDelegate extends BaseQueryDelegate<Query> implements StreamQuery {

    QueryDelegate(Query delegate) {
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
    public String getQueryString() {
        return delegate().getQueryString();
    }

    @Override
    public Integer getMaxResults() {
        return delegate().getMaxResults();
    }

    @Override
    public StreamQuery setMaxResults(int maxResults) {
        return wrap(delegate().setMaxResults(maxResults));
    }

    @Override
    public Integer getFirstResult() {
        return delegate().getFirstResult();
    }

    @Override
    public StreamQuery setFirstResult(int firstResult) {
        return wrap(delegate().setFirstResult(firstResult));
    }

    @Override
    public StreamQuery setFlushMode(FlushMode flushMode) {
        return wrap(delegate().setFlushMode(flushMode));
    }

    @Override
    public StreamQuery setCacheMode(CacheMode cacheMode) {
        return wrap(delegate().setCacheMode(cacheMode));
    }

    @Override
    public StreamQuery setCacheable(boolean cacheable) {
        return wrap(delegate().setCacheable(cacheable));
    }

    @Override
    public StreamQuery setCacheRegion(String cacheRegion) {
        return wrap(delegate().setCacheRegion(cacheRegion));
    }

    @Override
    public StreamQuery setTimeout(int timeout) {
        return wrap(delegate().setTimeout(timeout));
    }

    @Override
    public StreamQuery setFetchSize(int fetchSize) {
        return wrap(delegate().setFetchSize(fetchSize));
    }

    @Override
    public StreamQuery setReadOnly(boolean readOnly) {
        return wrap(delegate().setReadOnly(readOnly));
    }

    @Override
    public LockOptions getLockOptions() {
        return delegate().getLockOptions();
    }

    @Override
    public StreamQuery setLockOptions(LockOptions lockOptions) {
        return wrap(delegate().setLockOptions(lockOptions));
    }

    @Override
    public StreamQuery setLockMode(String alias, LockMode lockMode) {
        return wrap(delegate().setLockMode(alias, lockMode));
    }

    @Override
    public String getComment() {
        return delegate().getComment();
    }

    @Override
    public StreamQuery setComment(String comment) {
        return wrap(delegate().setComment(comment));
    }

    @Override
    public StreamQuery addQueryHint(String hint) {
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
    public StreamQuery setParameter(int position, Object val, Type type) {
        return wrap(delegate().setParameter(position, val, type));
    }

    @Override
    public StreamQuery setParameter(String name, Object val, Type type) {
        return wrap(delegate().setParameter(name, val, type));
    }

    @Override
    public StreamQuery setParameter(int position, Object val) {
        return wrap(delegate().setParameter(position, val));
    }

    @Override
    public StreamQuery setParameter(String name, Object val) {
        return wrap(delegate().setParameter(name, val));
    }

    @Override
    public StreamQuery setParameters(Object[] values, Type[] types) {
        return wrap(delegate().setParameters(values, types));
    }

    @Override
    public StreamQuery setParameterList(String name, Collection values, Type type) {
        return wrap(delegate().setParameterList(name, values, type));
    }

    @Override
    public StreamQuery setParameterList(String name, Collection values) {
        return wrap(delegate().setParameterList(name, values));
    }

    @Override
    public StreamQuery setParameterList(String name, Object[] values, Type type) {
        return wrap(delegate().setParameterList(name, values, type));
    }

    @Override
    public StreamQuery setParameterList(String name, Object[] values) {
        return wrap(delegate().setParameterList(name, values));
    }

    @Override
    public StreamQuery setProperties(Object bean) {
        return wrap(delegate().setProperties(bean));
    }

    @Override
    public StreamQuery setProperties(Map bean) {
        return wrap(delegate().setProperties(bean));
    }

    @Override
    public StreamQuery setString(int position, String val) {
        return wrap(delegate().setString(position, val));
    }

    @Override
    public StreamQuery setCharacter(int position, char val) {
        return wrap(delegate().setCharacter(position, val));
    }

    @Override
    public StreamQuery setBoolean(int position, boolean val) {
        return wrap(delegate().setBoolean(position, val));
    }

    @Override
    public StreamQuery setByte(int position, byte val) {
        return wrap(delegate().setByte(position, val));
    }

    @Override
    public StreamQuery setShort(int position, short val) {
        return wrap(delegate().setShort(position, val));
    }

    @Override
    public StreamQuery setInteger(int position, int val) {
        return wrap(delegate().setInteger(position, val));
    }

    @Override
    public StreamQuery setLong(int position, long val) {
        return wrap(delegate().setLong(position, val));
    }

    @Override
    public StreamQuery setFloat(int position, float val) {
        return wrap(delegate().setFloat(position, val));
    }

    @Override
    public StreamQuery setDouble(int position, double val) {
        return wrap(delegate().setDouble(position, val));
    }

    @Override
    public StreamQuery setBinary(int position, byte[] val) {
        return wrap(delegate().setBinary(position, val));
    }

    @Override
    public StreamQuery setText(int position, String val) {
        return wrap(delegate().setText(position, val));
    }

    @Override
    public StreamQuery setSerializable(int position, Serializable val) {
        return wrap(delegate().setSerializable(position, val));
    }

    @Override
    public StreamQuery setLocale(int position, Locale locale) {
        return wrap(delegate().setLocale(position, locale));
    }

    @Override
    public StreamQuery setBigDecimal(int position, BigDecimal number) {
        return wrap(delegate().setBigDecimal(position, number));
    }

    @Override
    public StreamQuery setBigInteger(int position, BigInteger number) {
        return wrap(delegate().setBigInteger(position, number));
    }

    @Override
    public StreamQuery setDate(int position, Date date) {
        return wrap(delegate().setDate(position, date));
    }

    @Override
    public StreamQuery setTime(int position, Date date) {
        return wrap(delegate().setTime(position, date));
    }

    @Override
    public StreamQuery setTimestamp(int position, Date date) {
        return wrap(delegate().setTimestamp(position, date));
    }

    @Override
    public StreamQuery setCalendar(int position, Calendar calendar) {
        return wrap(delegate().setCalendar(position, calendar));
    }

    @Override
    public StreamQuery setCalendarDate(int position, Calendar calendar) {
        return wrap(delegate().setCalendarDate(position, calendar));
    }

    @Override
    public StreamQuery setString(String name, String val) {
        return wrap(delegate().setString(name, val));
    }

    @Override
    public StreamQuery setCharacter(String name, char val) {
        return wrap(delegate().setCharacter(name, val));
    }

    @Override
    public StreamQuery setBoolean(String name, boolean val) {
        return wrap(delegate().setBoolean(name, val));
    }

    @Override
    public StreamQuery setByte(String name, byte val) {
        return wrap(delegate().setByte(name, val));
    }

    @Override
    public StreamQuery setShort(String name, short val) {
        return wrap(delegate().setShort(name, val));
    }

    @Override
    public StreamQuery setInteger(String name, int val) {
        return wrap(delegate().setInteger(name, val));
    }

    @Override
    public StreamQuery setLong(String name, long val) {
        return wrap(delegate().setLong(name, val));
    }

    @Override
    public StreamQuery setFloat(String name, float val) {
        return wrap(delegate().setFloat(name, val));
    }

    @Override
    public StreamQuery setDouble(String name, double val) {
        return wrap(delegate().setDouble(name, val));
    }

    @Override
    public StreamQuery setBinary(String name, byte[] val) {
        return wrap(delegate().setBinary(name, val));
    }

    @Override
    public StreamQuery setText(String name, String val) {
        return wrap(delegate().setText(name, val));
    }

    @Override
    public StreamQuery setSerializable(String name, Serializable val) {
        return wrap(delegate().setSerializable(name, val));
    }

    @Override
    public StreamQuery setLocale(String name, Locale locale) {
        return wrap(delegate().setLocale(name, locale));
    }

    @Override
    public StreamQuery setBigInteger(String name, BigInteger number) {
        return wrap(delegate().setBigInteger(name, number));
    }

    @Override
    public StreamQuery setBigDecimal(String name, BigDecimal number) {
        return wrap(delegate().setBigDecimal(name, number));
    }

    @Override
    public StreamQuery setDate(String name, Date date) {
        return wrap(delegate().setDate(name, date));
    }

    @Override
    public StreamQuery setTime(String name, Date date) {
        return wrap(delegate().setTime(name, date));
    }

    @Override
    public StreamQuery setTimestamp(String name, Date date) {
        return wrap(delegate().setTimestamp(name, date));
    }

    @Override
    public StreamQuery setCalendar(String name, Calendar calendar) {
        return wrap(delegate().setCalendar(name, calendar));
    }

    @Override
    public StreamQuery setCalendarDate(String name, Calendar calendar) {
        return wrap(delegate().setCalendarDate(name, calendar));
    }

    @Override
    public StreamQuery setEntity(int position, Object val) {
        return wrap(delegate().setEntity(position, val));
    }

    @Override
    public StreamQuery setEntity(String name, Object val) {
        return wrap(delegate().setEntity(name, val));
    }

    @Override
    public StreamQuery setResultTransformer(ResultTransformer transformer) {
        return wrap(delegate().setResultTransformer(transformer));
    }

    private StreamQuery wrap(final Query query) {
        return this;
    }
}
