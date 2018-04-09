package com.bruce.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by bruce on 2018/4/8.
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private  String name;

    CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "Hello, " + name + "!";
    }
}
