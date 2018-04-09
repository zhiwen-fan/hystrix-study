package com.bruce.hystrix;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.properties.HystrixDynamicPropertiesSystemProperties;

import java.util.concurrent.TimeUnit;

/**
 * Created by bruce on 2018/4/8.
 */
public class ThreadIsolationCommand extends HystrixCommand<String> {
    public ThreadIsolationCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ThreadIsolationCommand group"))

            .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadIsolationCommand pool"))
            .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(2)
                                                .withMaxQueueSize(3).withQueueSizeRejectionThreshold(2)));
    }


    protected String run() throws Exception {
        System.out.println("enter run method");
        //Thread.sleep(100);
        return "success";
    }

    @Override
    protected String getFallback() {
        //       System.out.println(this.getExecutionException().getClass());
//        if(this.isResponseRejected()) {
//            System.out.println("response rejected: " + this.isResponseRejected());
//        }
//        if(this.isResponseThreadPoolRejected()) {
//            System.out.println("thread pool response rejected: " + this.isResponseThreadPoolRejected());
//        }

        return "fail back: " + this.getExecutionException().getClass();
    }
}
