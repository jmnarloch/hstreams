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

import com.github.jmnarloch.hstreams.rule.VerifyNoMoreInteractionsRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

/**
 * Tests the {@link QueryDelegate} class.
 *
 * @author Jakub Narloch
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class BaseDelegateTest<D extends T, T> {

    /**
     * Verifies that the mock does not recorded any more method calls except from those defined.
     */
    @Rule
    public VerifyNoMoreInteractionsRule verifyNoMoreInteractions
            = new VerifyNoMoreInteractionsRule(() -> Arrays.asList(getMock()));

    /**
     * Retrieves the instance of the tested decorator class.
     *
     * @return the delegate class
     */
    protected abstract D getInstance();

    /**
     * Retrieves the instance of the delegated class.
     *
     * @return the instance of the delegated class
     */
    protected abstract T getMock();

    /**
     * Registers expectation and verifies it execution on the regitered mock instance.
     *
     * @param expectation the method call expectation
     * @throws Exception if any error occurs
     */
    protected void verifyMethodCall(Expectation<T> expectation) throws Exception {

        // performs actual call on the wrapper
        expectation.call(getInstance());

        // register the expectation on the mock
        expectation.call(Mockito.verify(getMock()));
    }

    /**
     * Returns the mock during the method verification phase.
     *
     * @return the mock instance
     */
    protected T verify() {

        return Mockito.verify(getMock());
    }

    /**
     * Defines the interface for defining the method call expectations.
     *
     * @param <T> the type
     */
    @FunctionalInterface
    public interface Expectation<T> {

        /**
         * Registers the call expectations.
         *
         * @param obj the obj
         * @throws Exception if any error occurs
         */
        void call(T obj) throws Exception;
    }
}
