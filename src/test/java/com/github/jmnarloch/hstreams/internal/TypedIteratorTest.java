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
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests the {@link TypedIterator} class.
 *
 * @author Jakub Narloch
 */
@RunWith(MockitoJUnitRunner.class)
public class TypedIteratorTest {

    /**
     * Represents the instance of the tested class.
     */
    private TypedIterator<Entity> instance;

    /**
     * The mocked instance of {@link Iterator} class.
     */
    @Mock
    private Iterator<Entity> iterator;

    /**
     * Verifies that the mock does not recorded any more method calls except from those defined.
     */
    @Rule
    public VerifyNoMoreInteractionsRule verifyNoMoreInteractions
            = new VerifyNoMoreInteractionsRule(() -> Arrays.asList(iterator));

    /**
     * Sets up the test environment.
     *
     * @throws Exception if any error occurs
     */
    @Before
    public void setUp() throws Exception {

        instance = new TypedIterator<>(iterator);
    }

    @Test
    public void testHasNext() throws Exception {

        // given
        when(iterator.hasNext()).thenReturn(true);

        // when
        final boolean result = instance.hasNext();

        // then
        verify(iterator).hasNext();
        assertTrue(result);
    }

    @Test
    public void testNext() throws Exception {

        // given
        final Entity entity = new Entity();
        when(iterator.next()).thenReturn(entity);

        // when
        final Entity result = instance.next();

        // then
        verify(iterator).next();
        assertEquals(entity, result);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemove() throws Exception {

        // when
        instance.remove();

        // then
        verify(iterator).remove();
    }
}