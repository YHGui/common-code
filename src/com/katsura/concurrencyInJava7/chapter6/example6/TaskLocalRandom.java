package com.katsura.concurrencyInJava7.chapter6.example6;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Katsura on 2017/4/16.
 */
public class TaskLocalRandom implements Runnable{
    public TaskLocalRandom() {
        ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: %d\n", name, ThreadLocalRandom.current().nextInt(10));
        }
    }
}
