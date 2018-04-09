package com.bruce.hystrix;

import org.junit.Test;

public class ThreadIsolationTest {

    @Test
    public void testThreadIsolation() {
        ThreadIsolationCommand threadIsolationCommand = new ThreadIsolationCommand();
        String result = threadIsolationCommand.execute();
        System.out.println(result);
    }

    @Test
    public void testThreadPoolRejected() throws InterruptedException {
            for (int i=0; i<10;i++) {

                new Thread(new Runnable(){

                    public void run() {
                        System.out.println(new ThreadIsolationCommand().execute());
                    }
                }).start();
            }

            Thread.sleep(3000);
        }

}
