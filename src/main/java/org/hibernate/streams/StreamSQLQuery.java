package org.hibernate.streams;

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
 * @author Jakub Narloch
 */
public interface StreamSQLQuery extends SQLQuery, BaseStreamQuery {

    @Override
    StreamSQLQuery addSynchronizedQuerySpace(String querySpace);

    @Override
    StreamSQLQuery addSynchronizedEntityName(String entityName) throws MappingException;

    @Override
    StreamSQLQuery addSynchronizedEntityClass(Class entityClass) throws MappingException;

    @Override
    StreamSQLQuery setResultSetMapping(String name);

    @Override
    StreamSQLQuery addScalar(String columnAlias);

    @Override
    StreamSQLQuery addScalar(String columnAlias, Type type);

    @Override
    StreamSQLQuery addEntity(String entityName);

    @Override
    StreamSQLQuery addEntity(String tableAlias, String entityName);

    @Override
    StreamSQLQuery addEntity(String tableAlias, String entityName, LockMode lockMode);

    @Override
    StreamSQLQuery addEntity(Class entityType);

    @Override
    StreamSQLQuery addEntity(String tableAlias, Class entityType);

    @Override
    StreamSQLQuery addEntity(String tableAlias, Class entityName, LockMode lockMode);

    @Override
    StreamSQLQuery addJoin(String tableAlias, String path);

    @Override
    StreamSQLQuery addJoin(String tableAlias, String ownerTableAlias, String joinPropertyName);

    @Override
    StreamSQLQuery addJoin(String tableAlias, String path, LockMode lockMode);

    @Override
    StreamSQLQuery setMaxResults(int maxResults);

    @Override
    StreamSQLQuery setFirstResult(int firstResult);

    @Override
    StreamSQLQuery setFlushMode(FlushMode flushMode);

    @Override
    StreamSQLQuery setCacheMode(CacheMode cacheMode);

    @Override
    StreamSQLQuery setCacheable(boolean cacheable);

    @Override
    StreamSQLQuery setCacheRegion(String cacheRegion);

    @Override
    StreamSQLQuery setTimeout(int timeout);

    @Override
    StreamSQLQuery setFetchSize(int fetchSize);

    @Override
    StreamSQLQuery setReadOnly(boolean readOnly);

    @Override
    StreamSQLQuery setLockOptions(LockOptions lockOptions);

    @Override
    StreamSQLQuery setLockMode(String alias, LockMode lockMode);

    @Override
    StreamSQLQuery setComment(String comment);

    @Override
    StreamSQLQuery addQueryHint(String hint);

    @Override
    StreamSQLQuery setParameter(int position, Object val, Type type);

    @Override
    StreamSQLQuery setParameter(String name, Object val, Type type);

    @Override
    StreamSQLQuery setParameter(int position, Object val);

    @Override
    StreamSQLQuery setParameter(String name, Object val);

    @Override
    StreamSQLQuery setParameters(Object[] values, Type[] types);

    @Override
    StreamSQLQuery setParameterList(String name, Collection values, Type type);

    @Override
    StreamSQLQuery setParameterList(String name, Object[] values, Type type);

    @Override
    StreamSQLQuery setParameterList(String name, Collection values);

    @Override
    StreamSQLQuery setParameterList(String name, Object[] values);

    @Override
    StreamSQLQuery setProperties(Object bean);

    @Override
    StreamSQLQuery setProperties(Map bean);

    @Override
    StreamSQLQuery setString(int position, String val);

    @Override
    StreamSQLQuery setCharacter(int position, char val);

    @Override
    StreamSQLQuery setBoolean(int position, boolean val);

    @Override
    StreamSQLQuery setByte(int position, byte val);

    @Override
    StreamSQLQuery setShort(int position, short val);

    @Override
    StreamSQLQuery setInteger(int position, int val);

    @Override
    StreamSQLQuery setLong(int position, long val);

    @Override
    StreamSQLQuery setFloat(int position, float val);

    @Override
    StreamSQLQuery setDouble(int position, double val);

    @Override
    StreamSQLQuery setBinary(int position, byte[] val);

    @Override
    StreamSQLQuery setText(int position, String val);

    @Override
    StreamSQLQuery setSerializable(int position, Serializable val);

    @Override
    StreamSQLQuery setBigDecimal(int position, BigDecimal number);

    @Override
    StreamSQLQuery setLocale(int position, Locale locale);

    @Override
    StreamSQLQuery setBigInteger(int position, BigInteger number);

    @Override
    StreamSQLQuery setDate(int position, Date date);

    @Override
    StreamSQLQuery setTime(int position, Date date);

    @Override
    StreamSQLQuery setTimestamp(int position, Date date);

    @Override
    StreamSQLQuery setCalendarDate(int position, Calendar calendar);

    @Override
    StreamSQLQuery setCalendar(int position, Calendar calendar);

    @Override
    StreamSQLQuery setString(String name, String val);

    @Override
    StreamSQLQuery setCharacter(String name, char val);

    @Override
    StreamSQLQuery setBoolean(String name, boolean val);

    @Override
    StreamSQLQuery setByte(String name, byte val);

    @Override
    StreamSQLQuery setShort(String name, short val);

    @Override
    StreamSQLQuery setInteger(String name, int val);

    @Override
    StreamSQLQuery setLong(String name, long val);

    @Override
    StreamSQLQuery setFloat(String name, float val);

    @Override
    StreamSQLQuery setDouble(String name, double val);

    @Override
    StreamSQLQuery setBinary(String name, byte[] val);

    @Override
    StreamSQLQuery setSerializable(String name, Serializable val);

    @Override
    StreamSQLQuery setText(String name, String val);

    @Override
    StreamSQLQuery setLocale(String name, Locale locale);

    @Override
    StreamSQLQuery setBigDecimal(String name, BigDecimal number);

    @Override
    StreamSQLQuery setBigInteger(String name, BigInteger number);

    @Override
    StreamSQLQuery setDate(String name, Date date);

    @Override
    StreamSQLQuery setTimestamp(String name, Date date);

    @Override
    StreamSQLQuery setTime(String name, Date date);

    @Override
    StreamSQLQuery setCalendar(String name, Calendar calendar);

    @Override
    StreamSQLQuery setCalendarDate(String name, Calendar calendar);

    @Override
    StreamSQLQuery setEntity(int position, Object val);

    @Override
    StreamSQLQuery setEntity(String name, Object val);

    @Override
    StreamSQLQuery setResultTransformer(ResultTransformer transformer);
}
