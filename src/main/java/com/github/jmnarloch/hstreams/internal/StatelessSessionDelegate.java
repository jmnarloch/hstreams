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
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Optional;

/**
 * The {@link StatelessSession} decorator.
 *
 * @author Jakub Narloch
 */
class StatelessSessionDelegate implements StreamStatelessSession {

    private final StatelessSession delegate;

    StatelessSessionDelegate(StatelessSession delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getTenantIdentifier() {
        return delegate.getTenantIdentifier();
    }

    @Override
    public Transaction beginTransaction() {
        return delegate.beginTransaction();
    }

    @Override
    public Transaction getTransaction() {
        return delegate.getTransaction();
    }

    @Override
    public StreamQuery getNamedQuery(String queryName) {
        return new QueryDelegate(delegate.getNamedQuery(queryName));
    }

    @Override
    public StreamQuery createQuery(String queryString) {
        return new QueryDelegate(delegate.createQuery(queryString));
    }

    @Override
    public <T> StreamTypedQuery<T> createTypedQuery(String queryString, Class<T> clazz) {
        return new TypedQueryDelegate<>(createQuery(queryString), clazz);
    }

    @Override
    public <T> StreamTypedQuery<T> getTypedNamedQuery(String queryName, Class<T> clazz) {
        return new TypedQueryDelegate<>(getNamedQuery(queryName), clazz);
    }

    @Override
    public StreamSQLQuery createSQLQuery(String queryString) {
        return new SQLQueryDelegate(delegate.createSQLQuery(queryString));
    }

    @Override
    public <T> StreamTypedSQLQuery<T> createTypedSQLQuery(String queryString, Class<T> clazz) {
        return new TypedSQLQueryDelegate<>(createSQLQuery(queryString), clazz);
    }

    @Override
    public ProcedureCall getNamedProcedureCall(String name) {
        return delegate.getNamedProcedureCall(name);
    }

    @Override
    public ProcedureCall createStoredProcedureCall(String procedureName) {
        return delegate.createStoredProcedureCall(procedureName);
    }

    @Override
    public ProcedureCall createStoredProcedureCall(String procedureName, Class... resultClasses) {
        return delegate.createStoredProcedureCall(procedureName, resultClasses);
    }

    @Override
    public ProcedureCall createStoredProcedureCall(String procedureName, String... resultSetMappings) {
        return delegate.createStoredProcedureCall(procedureName, resultSetMappings);
    }

    @Override
    public Criteria createCriteria(Class persistentClass) {
        return delegate.createCriteria(persistentClass);
    }

    @Override
    public Criteria createCriteria(Class persistentClass, String alias) {
        return delegate.createCriteria(persistentClass, alias);
    }

    @Override
    public Criteria createCriteria(String entityName) {
        return delegate.createCriteria(entityName);
    }

    @Override
    public Criteria createCriteria(String entityName, String alias) {
        return delegate.createCriteria(entityName, alias);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> getOptional(Class<T> clazz, Serializable id) {
        return Optional.<T>ofNullable((T) get(clazz, id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> getOptional(Class<T> clazz, Serializable id, LockMode lockMode) {
        return Optional.<T>ofNullable((T) get(clazz, id, lockMode));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> getOptional(String entityName, Serializable id) {
        return Optional.<T>ofNullable((T) get(entityName, id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> getOptional(String entityName, Serializable id, LockMode lockMode) {
        return Optional.<T>ofNullable((T) get(entityName, id, lockMode));
    }

    @Override
    public void close() {
        delegate.close();
    }

    @Override
    public Serializable insert(Object entity) {
        return delegate.insert(entity);
    }

    @Override
    public Serializable insert(String entityName, Object entity) {
        return delegate.insert(entityName, entity);
    }

    @Override
    public void update(Object entity) {
        delegate.update(entity);
    }

    @Override
    public void update(String entityName, Object entity) {
        delegate.update(entityName, entity);
    }

    @Override
    public void delete(Object entity) {
        delegate.delete(entity);
    }

    @Override
    public void delete(String entityName, Object entity) {
        delegate.delete(entityName, entity);
    }

    @Override
    public Object get(String entityName, Serializable id) {
        return delegate.get(entityName, id);
    }

    @Override
    public Object get(Class entityClass, Serializable id) {
        return delegate.get(entityClass, id);
    }

    @Override
    public Object get(String entityName, Serializable id, LockMode lockMode) {
        return delegate.get(entityName, id, lockMode);
    }

    @Override
    public Object get(Class entityClass, Serializable id, LockMode lockMode) {
        return delegate.get(entityClass, id, lockMode);
    }

    @Override
    public void refresh(Object entity) {
        delegate.refresh(entity);
    }

    @Override
    public void refresh(String entityName, Object entity) {
        delegate.refresh(entityName, entity);
    }

    @Override
    public void refresh(Object entity, LockMode lockMode) {
        delegate.refresh(entity, lockMode);
    }

    @Override
    public void refresh(String entityName, Object entity, LockMode lockMode) {
        delegate.refresh(entityName, entity, lockMode);
    }

    @Override
    public Connection connection() {
        return delegate.connection();
    }
}
