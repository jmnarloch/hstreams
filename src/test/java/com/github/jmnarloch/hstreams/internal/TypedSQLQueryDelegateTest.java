/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams.internal;

import com.github.jmnarloch.hstreams.model.Entity;
import com.github.jmnarloch.hstreams.rule.VerifyNoMoreInteractionsRule;
import org.hibernate.SQLQuery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Tests the {@link TypedSQLQueryDelegate} class.
 *
 * @author Jakub Narloch
 */
@RunWith(MockitoJUnitRunner.class)
public class TypedSQLQueryDelegateTest {

    // TODO make actual result assertions

    /**
     * The instance of the tested class.
     */
    private TypedSQLQueryDelegate<Entity> instance;

    /**
     * The mocked {@link SQLQuery} instance.
     */
    @Mock
    private SQLQuery sqlQuery;

    /**
     * Verifies that the mock does not recorded any more method calls except from those defined.
     */
    @Rule
    public VerifyNoMoreInteractionsRule verifyNoMoreInteractions
            = new VerifyNoMoreInteractionsRule(() -> Arrays.asList(sqlQuery));


    /**
     * Setups the test environment.
     *
     * @throws Exception if any error occurs
     */
    @Before
    public void setUp() throws Exception {

        instance = new TypedSQLQueryDelegate<>(sqlQuery, Entity.class);
    }

    @Test
    public void testList() throws Exception {

        // when
        List<Entity> result = instance.list();

        // then
        Mockito.verify(sqlQuery).list();
    }

    @Test
    public void testUniqueResult() throws Exception {

        // when
        Entity result = instance.uniqueResult();

        // then
        Mockito.verify(sqlQuery).uniqueResult();
    }

    @Test
    public void testIterate() throws Exception {

        // when
        Iterator<Entity> result = instance.iterate();

        // then
        Mockito.verify(sqlQuery).iterate();
    }

    @Test
    public void testStream() throws Exception {

        // when
        Stream<Entity> result = instance.stream();

        // then
        Mockito.verify(sqlQuery).list();
    }

    @Test
    public void testParallelStream() throws Exception {

        // when
        Stream<Entity> result = instance.parallelStream();

        // then
        Mockito.verify(sqlQuery).list();
    }

    @Test
    public void testOptionalResult() throws Exception {

        // when
        Optional<Entity> result = instance.optionalResult();

        // then
        Mockito.verify(sqlQuery).uniqueResult();
    }
}