package com.bruce.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Created by bruce on 2018/4/8.
 */
public class TimeoutCommand extends HystrixCommand<String> {

    public TimeoutCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Example group"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(100)));
    }


    protected String run() throws Exception {
        Thread.sleep(1000);
        return "time out";
    }

    @Override
    protected String getFallback() {
        Throwable exception = this.getExecutionException();
        System.out.println(exception.getClass());
        System.out.println(exception.getMessage());
        if(this.isFailedExecution()) {
            return "fall back, underlying exception";
        } else if (this.isResponseTimedOut()) {
            return "fall back, time out" ;
        } else {
            return "fall back: " + exception.getMessage();
        }
    }

}
