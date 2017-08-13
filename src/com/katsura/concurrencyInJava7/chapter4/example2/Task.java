package com.katsura.concurrencyInJava7.chapter4.example2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/14.
 */
public class Task implements Runnable{
    private Date initDate;
    private String name;

    public Task(Date initDate, String name) {
        this.initDate = initDate;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Task %s: Created on: %s\n",
                            Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s: Task %s: Started on: %s\n",
                            Thread.currentThread().getName(), name, new Date());
        Long duration = (long) (Math.random() * 10);
        System.out.printf("%s: Task %s: Doing a task during %d seconds\n",
                            Thread.currentThread().getName(), name, duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: Task %s: Finished on: %s\n",
                Thread.currentThread().getName(), name, new Date());
    }
}
