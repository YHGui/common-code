package com.katsura.concurrencyInJava7.chapter1.example9;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/12.
 */
public class SafeTask implements Runnable{
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(), startDate.get());
    }
}
