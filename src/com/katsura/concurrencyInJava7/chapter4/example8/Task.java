package com.katsura.concurrencyInJava7.chapter4.example8;

import java.util.concurrent.Callable;

/**
 * Created by Katsura on 2017/4/14.
 */
public class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        while (true) {
            System.out.printf("Task: Test\n");
            Thread.sleep(1000);
        }
    }
}
