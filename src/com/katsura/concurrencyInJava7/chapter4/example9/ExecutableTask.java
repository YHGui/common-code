package com.katsura.concurrencyInJava7.chapter4.example9;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/14.
 */
public class ExecutableTask implements Callable<String> {
    private String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String call() throws Exception{
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, world. I'm " + name;
    }
}
