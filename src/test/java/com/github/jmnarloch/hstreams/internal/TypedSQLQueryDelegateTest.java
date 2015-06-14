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