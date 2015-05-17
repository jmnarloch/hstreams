package org.hibernate.streams;

import org.hibernate.StatelessSessionBuilder;

import java.sql.Connection;

/**
 * A wrapper around the {@link StatelessSessionBuilder} interface that overrides most of the methods return types.
 *
 * @author Jakub Narloch
 */
public interface StreamStatelessSessionBuilder extends StatelessSessionBuilder {

    /**
     * {@inheritDoc}
     */
    @Override
    StreamStatelessSession openStatelessSession();

    /**
     * {@inheritDoc}
     */
    @Override
    StreamStatelessSessionBuilder connection(Connection connection);

    /**
     * {@inheritDoc}
     */
    @Override
    StreamStatelessSessionBuilder tenantIdentifier(String tenantIdentifier);
}
