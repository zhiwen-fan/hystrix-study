package com.bruce.hystrix;

import org.junit.Test;
import rx.Observable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by bruce on 2018/4/8.
 */
public class HelloWorldTest {

    @Test
    public void testHelloWord() {

        CommandHelloWorld commandHelloWorld = new CommandHelloWorld("bruce");
        String result = commandHelloWorld.execute();
        System.out.println(result);
    }

    @Test
    public void testHelloWordWithQueue() throws ExecutionException, InterruptedException {
        CommandHelloWorld commandHelloWorld = new CommandHelloWorld("tom");
        Future<String> result = commandHelloWorld.queue();
        System.out.println(result.get());
    }

    @Test
    public void testHelloWordWithObserve() throws ExecutionException, InterruptedException {
        CommandHelloWorld commandHelloWorld = new CommandHelloWorld("fan");
        Observable<String> observe = commandHelloWorld.observe();
        System.out.println(observe.toBlocking().single());
    }

    @Test
    public void testHelloWordWithObservable() throws ExecutionException, InterruptedException {
        CommandHelloWorld commandHelloWorld = new CommandHelloWorld("lin");
        Observable<String> observe = commandHelloWorld.observe();
        System.out.println(observe.toBlocking().single());
    }
}
