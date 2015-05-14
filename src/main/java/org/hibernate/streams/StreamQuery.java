package org.hibernate.streams;

import org.hibernate.*;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 *
 */
public interface StreamQuery extends Query, BaseStreamQuery {

    @Override
    StreamQuery setMaxResults(int maxResults);

    @Override
    StreamQuery setFirstResult(int firstResult);

    @Override
    StreamQuery setFlushMode(FlushMode flushMode);

    @Override
    StreamQuery setCacheMode(CacheMode cacheMode);

    @Override
    StreamQuery setCacheable(boolean cacheable);

    @Override
    StreamQuery setCacheRegion(String cacheRegion);

    @Override
    StreamQuery setTimeout(int timeout);

    @Override
    StreamQuery setFetchSize(int fetchSize);

    @Override
    StreamQuery setReadOnly(boolean readOnly);

    @Override
    StreamQuery setLockOptions(LockOptions lockOptions);

    @Override
    StreamQuery setLockMode(String alias, LockMode lockMode);

    @Override
    StreamQuery setComment(String comment);

    @Override
    StreamQuery addQueryHint(String hint);

    @Override
    StreamQuery setParameter(int position, Object val, Type type);

    @Override
    StreamQuery setParameter(String name, Object val, Type type);

    @Override
    StreamQuery setParameter(int position, Object val);

    @Override
    StreamQuery setParameter(String name, Object val);

    @Override
    StreamQuery setParameters(Object[] values, Type[] types);

    @Override
    StreamQuery setParameterList(String name, Collection values, Type type);

    @Override
    StreamQuery setParameterList(String name, Collection values);

    @Override
    StreamQuery setParameterList(String name, Object[] values, Type type);

    @Override
    StreamQuery setParameterList(String name, Object[] values);

    @Override
    StreamQuery setProperties(Object bean);

    @Override
    StreamQuery setProperties(Map bean);

    @Override
    StreamQuery setString(int position, String val);

    @Override
    StreamQuery setCharacter(int position, char val);

    @Override
    StreamQuery setBoolean(int position, boolean val);

    @Override
    StreamQuery setByte(int position, byte val);

    @Override
    StreamQuery setShort(int position, short val);

    @Override
    StreamQuery setInteger(int position, int val);

    @Override
    StreamQuery setLong(int position, long val);

    @Override
    StreamQuery setFloat(int position, float val);

    @Override
    StreamQuery setDouble(int position, double val);

    @Override
    StreamQuery setBinary(int position, byte[] val);

    @Override
    StreamQuery setText(int position, String val);

    @Override
    StreamQuery setSerializable(int position, Serializable val);

    @Override
    StreamQuery setLocale(int position, Locale locale);

    @Override
    StreamQuery setBigDecimal(int position, BigDecimal number);

    @Override
    StreamQuery setBigInteger(int position, BigInteger number);

    @Override
    StreamQuery setDate(int position, Date date);

    @Override
    StreamQuery setTime(int position, Date date);

    @Override
    StreamQuery setTimestamp(int position, Date date);

    @Override
    StreamQuery setCalendar(int position, Calendar calendar);

    @Override
    StreamQuery setCalendarDate(int position, Calendar calendar);

    @Override
    StreamQuery setString(String name, String val);

    @Override
    StreamQuery setCharacter(String name, char val);

    @Override
    StreamQuery setBoolean(String name, boolean val);

    @Override
    StreamQuery setByte(String name, byte val);

    @Override
    StreamQuery setShort(String name, short val);

    @Override
    StreamQuery setInteger(String name, int val);

    @Override
    StreamQuery setLong(String name, long val);

    @Override
    StreamQuery setFloat(String name, float val);

    @Override
    StreamQuery setDouble(String name, double val);

    @Override
    StreamQuery setBinary(String name, byte[] val);

    @Override
    StreamQuery setText(String name, String val);

    @Override
    StreamQuery setSerializable(String name, Serializable val);

    @Override
    StreamQuery setLocale(String name, Locale locale);

    @Override
    StreamQuery setBigInteger(String name, BigInteger number);

    @Override
    StreamQuery setBigDecimal(String name, BigDecimal number);

    @Override
    StreamQuery setDate(String name, Date date);

    @Override
    StreamQuery setTime(String name, Date date);

    @Override
    StreamQuery setTimestamp(String name, Date date);

    @Override
    StreamQuery setCalendar(String name, Calendar calendar);

    @Override
    StreamQuery setCalendarDate(String name, Calendar calendar);

    @Override
    StreamQuery setEntity(int position, Object val);

    @Override
    StreamQuery setEntity(String name, Object val);

    @Override
    StreamQuery setResultTransformer(ResultTransformer transformer);
}
