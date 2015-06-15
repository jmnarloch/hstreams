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

import com.github.jmnarloch.hstreams.*;
import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

import javax.naming.NamingException;
import javax.naming.Reference;
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
    public SessionFactoryOptions getSessionFactoryOptions() {
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
