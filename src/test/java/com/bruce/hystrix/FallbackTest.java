package com.bruce.hystrix;

import org.junit.Test;

/**
 * Created by bruce on 2018/4/8.
 */
public class FallbackTest {

    @Test
    public void testFallbackWithException() {
        FallbackWithExceptionCommand fallbackWithException = new FallbackWithExceptionCommand("bruce");
        String result = fallbackWithException.execute();
        System.out.println(result);
    }

    @Test
    public void testFallbackWithTimeout() {
        TimeoutCommand timeoutCommand = new TimeoutCommand();
        String result = timeoutCommand.execute();
        System.out.println(result);
    }
}
