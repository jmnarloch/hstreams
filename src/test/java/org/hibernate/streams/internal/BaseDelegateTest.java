package org.hibernate.streams.internal;

import org.hibernate.streams.rule.VerifyNoMoreInteractionsRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

/**
 *
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

    protected void verifyMethodCall(Expectation<T> expectation) throws Exception {

        expectation.call(getInstance());

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


    public interface Expectation<T> {

        void call(T obj) throws Exception;
    }
}
