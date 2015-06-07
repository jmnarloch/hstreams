package com.github.jmnarloch.hstreams.internal;

import org.hibernate.SQLQuery;
import com.github.jmnarloch.hstreams.StreamTypedSQLQuery;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The strongly typed query delegate implementation.
 *
 * @param <T> the entity type
 * @author Jakub Narloch
 */
class TypedSQLQueryDelegate<T> extends SQLQueryDelegate<StreamTypedSQLQuery<T>> implements StreamTypedSQLQuery<T> {

    /**
     * The entity class.
     */
    private final Class<T> type;

    /**
     * Creates new instance of {@link TypedSQLQueryDelegate} class.
     *
     * @param delegate the delegated query instance
     * @param type     the entity type
     */
    public TypedSQLQueryDelegate(SQLQuery delegate, Class<T> type) {
        super(delegate);
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> list() {
        // TODO convert to typed list
        return super.list();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public T uniqueResult() {
        return (T) super.uniqueResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterate() {
        return new TypedIterator<>(super.iterate());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<T> stream() {
        return list().stream();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Stream<T> parallelStream() {
        return list().parallelStream();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<T> optionalResult() {
        return Optional.ofNullable(uniqueResult());
    }
}
