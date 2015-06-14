/*
 * Copyright (c) 2015 HStreams contributors
 *
 * This program is made available under the terms of the Apache 2.0 License.
 */
package com.github.jmnarloch.hstreams.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.Mockito;

import java.util.List;
import java.util.function.Supplier;

/**
 * A testing rule that verifies that the mocks does not had any other method calls except from those that were declared.
 *
 * @author Jakub Narloch
 */
public class VerifyNoMoreInteractionsRule implements TestRule {

    /**
     * The mocks supplier.
     */
    private final Supplier<List> supplier;

    /**
     * Creates new instance of {@link VerifyNoMoreInteractionsRule} class.
     *
     * @param supplier the mocks supplier
     */
    public VerifyNoMoreInteractionsRule(Supplier<List> supplier) {
        this.supplier = supplier;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                base.evaluate();

                supplier.get().forEach(Mockito::verifyNoMoreInteractions);
            }
        };
    }
}
