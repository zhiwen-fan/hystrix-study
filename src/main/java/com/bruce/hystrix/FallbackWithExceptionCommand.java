package com.bruce.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by bruce on 2018/4/8.
 */
public class FallbackWithExceptionCommand extends HystrixCommand<String> {
    private String name;

    public FallbackWithExceptionCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("Example group"));
        this.name = name;
    }

    protected String run() throws Exception {
        throw  new RuntimeException("always fails");
    }

    protected String getFallback() {
        Throwable exception = this.getExecutionException();
        System.out.println(exception.getClass());
        System.out.println(exception.getMessage());
        if(this.isFailedExecution()) {
            return "fall back, underlying exception" + name;
        } else if (this.isResponseTimedOut()) {
            return "fall back, time out" + name;
        } else {
            return "fall back: " + exception.getMessage();
        }
    }
}
