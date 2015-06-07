package com.github.jmnarloch.hstreams;

import org.hibernate.*;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * A wrapper around the {@link Query} interface that overrides most of the methods return types.
 *
 * @param <Q> the actual stream query type
 * @author Jakub Narloch
 */
public interface StreamQuery<Q extends StreamQuery<Q>> extends Query, BaseStreamQuery {

    @Override
    Q setMaxResults(int maxResults);

    @Override
    Q setFirstResult(int firstResult);

    @Override
    Q setFlushMode(FlushMode flushMode);

    @Override
    Q setCacheMode(CacheMode cacheMode);

    @Override
    Q setCacheable(boolean cacheable);

    @Override
    Q setCacheRegion(String cacheRegion);

    @Override
    Q setTimeout(int timeout);

    @Override
    Q setFetchSize(int fetchSize);

    @Override
    Q setReadOnly(boolean readOnly);

    @Override
    Q setLockOptions(LockOptions lockOptions);

    @Override
    Q setLockMode(String alias, LockMode lockMode);

    @Override
    Q setComment(String comment);

    @Override
    Q addQueryHint(String hint);

    @Override
    Q setParameter(int position, Object val, Type type);

    @Override
    Q setParameter(String name, Object val, Type type);

    @Override
    Q setParameter(int position, Object val);

    @Override
    Q setParameter(String name, Object val);

    @Override
    Q setParameters(Object[] values, Type[] types);

    @Override
    Q setParameterList(String name, Collection values, Type type);

    @Override
    Q setParameterList(String name, Collection values);

    @Override
    Q setParameterList(String name, Object[] values, Type type);

    @Override
    Q setParameterList(String name, Object[] values);

    @Override
    Q setProperties(Object bean);

    @Override
    Q setProperties(Map bean);

    @Override
    Q setString(int position, String val);

    @Override
    Q setCharacter(int position, char val);

    @Override
    Q setBoolean(int position, boolean val);

    @Override
    Q setByte(int position, byte val);

    @Override
    Q setShort(int position, short val);

    @Override
    Q setInteger(int position, int val);

    @Override
    Q setLong(int position, long val);

    @Override
    Q setFloat(int position, float val);

    @Override
    Q setDouble(int position, double val);

    @Override
    Q setBinary(int position, byte[] val);

    @Override
    Q setText(int position, String val);

    @Override
    Q setSerializable(int position, Serializable val);

    @Override
    Q setLocale(int position, Locale locale);

    @Override
    Q setBigDecimal(int position, BigDecimal number);

    @Override
    Q setBigInteger(int position, BigInteger number);

    @Override
    Q setDate(int position, Date date);

    @Override
    Q setTime(int position, Date date);

    @Override
    Q setTimestamp(int position, Date date);

    @Override
    Q setCalendar(int position, Calendar calendar);

    @Override
    Q setCalendarDate(int position, Calendar calendar);

    @Override
    Q setString(String name, String val);

    @Override
    Q setCharacter(String name, char val);

    @Override
    Q setBoolean(String name, boolean val);

    @Override
    Q setByte(String name, byte val);

    @Override
    Q setShort(String name, short val);

    @Override
    Q setInteger(String name, int val);

    @Override
    Q setLong(String name, long val);

    @Override
    Q setFloat(String name, float val);

    @Override
    Q setDouble(String name, double val);

    @Override
    Q setBinary(String name, byte[] val);

    @Override
    Q setText(String name, String val);

    @Override
    Q setSerializable(String name, Serializable val);

    @Override
    Q setLocale(String name, Locale locale);

    @Override
    Q setBigInteger(String name, BigInteger number);

    @Override
    Q setBigDecimal(String name, BigDecimal number);

    @Override
    Q setDate(String name, Date date);

    @Override
    Q setTime(String name, Date date);

    @Override
    Q setTimestamp(String name, Date date);

    @Override
    Q setCalendar(String name, Calendar calendar);

    @Override
    Q setCalendarDate(String name, Calendar calendar);

    @Override
    Q setEntity(int position, Object val);

    @Override
    Q setEntity(String name, Object val);

    @Override
    Q setResultTransformer(ResultTransformer transformer);
}
