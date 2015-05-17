package org.hibernate.streams.internal;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.TypeHelper;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.hibernate.streams.*;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

/**
 * The {@link SessionFactory} decorator.
 *
 * @author Jakub Narloch
 */
class SessionFactoryDelegate implements StreamSessionFactory {

    private final SessionFactory delegate;

    SessionFactoryDelegate(SessionFactory delegate) {
        this.delegate = delegate;
    }

    @Override
    public SessionFactory.SessionFactoryOptions getSessionFactoryOptions() {
        return delegate.getSessionFactoryOptions();
    }

    @Override
    public StreamSessionBuilder withOptions() {
        return new StreamSessionBuilderDelegate(delegate.withOptions());
    }

    @Override
    public StreamSession openSession() throws HibernateException {
        return new SessionDelegate(delegate.openSession());
    }

    @Override
    public StreamSession getCurrentSession() throws HibernateException {
        return new SessionDelegate(delegate.getCurrentSession());
    }

    @Override
    public StreamStatelessSessionBuilder withStatelessOptions() {
        return new StatelessSessionBuilderDelegate(delegate.withStatelessOptions());
    }

    @Override
    public StreamStatelessSession openStatelessSession() {
        return new StatelessSessionDelegate(delegate.openStatelessSession());
    }

    @Override
    public StreamStatelessSession openStatelessSession(Connection connection) {
        return new StatelessSessionDelegate(delegate.openStatelessSession(connection));
    }

    @Override
    public ClassMetadata getClassMetadata(Class entityClass) {
        return delegate.getClassMetadata(entityClass);
    }

    @Override
    public ClassMetadata getClassMetadata(String entityName) {
        return delegate.getClassMetadata(entityName);
    }

    @Override
    public CollectionMetadata getCollectionMetadata(String roleName) {
        return delegate.getCollectionMetadata(roleName);
    }

    @Override
    public Map<String, ClassMetadata> getAllClassMetadata() {
        return delegate.getAllClassMetadata();
    }

    @Override
    public Map getAllCollectionMetadata() {
        return delegate.getAllCollectionMetadata();
    }

    @Override
    public Statistics getStatistics() {
        return delegate.getStatistics();
    }

    @Override
    public void close() throws HibernateException {
        delegate.close();
    }

    @Override
    public boolean isClosed() {
        return delegate.isClosed();
    }

    @Override
    public Cache getCache() {
        return delegate.getCache();
    }

    @Override
    public void evict(Class persistentClass) throws HibernateException {
        delegate.evict(persistentClass);
    }

    @Override
    public void evict(Class persistentClass, Serializable id) throws HibernateException {
        delegate.evict(persistentClass, id);
    }

    @Override
    public void evictEntity(String entityName) throws HibernateException {
        delegate.evictEntity(entityName);
    }

    @Override
    public void evictEntity(String entityName, Serializable id) throws HibernateException {
        delegate.evictEntity(entityName, id);
    }

    @Override
    public void evictCollection(String roleName) throws HibernateException {
        delegate.evictCollection(roleName);
    }

    @Override
    public void evictCollection(String roleName, Serializable id) throws HibernateException {
        delegate.evictCollection(roleName, id);
    }

    @Override
    public void evictQueries(String cacheRegion) throws HibernateException {
        delegate.evictQueries(cacheRegion);
    }

    @Override
    public void evictQueries() throws HibernateException {
        delegate.evictQueries();
    }

    @Override
    public Set getDefinedFilterNames() {
        return delegate.getDefinedFilterNames();
    }

    @Override
    public FilterDefinition getFilterDefinition(String filterName) throws HibernateException {
        return delegate.getFilterDefinition(filterName);
    }

    @Override
    public boolean containsFetchProfileDefinition(String name) {
        return delegate.containsFetchProfileDefinition(name);
    }

    @Override
    public TypeHelper getTypeHelper() {
        return delegate.getTypeHelper();
    }

    @Override
    public Reference getReference() throws NamingException {
        return delegate.getReference();
    }
}
