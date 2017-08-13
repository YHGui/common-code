package com.katsura.concurrencyInJava7.chapter3.example1;

import java.util.concurrent.Semaphore;

/**
 * Created by Katsura on 2017/4/13.
 */
public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }

    public void printJob (Object document) {
        try {
            semaphore.acquire();
            long duration = (long)(Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",
                                Thread.currentThread().getName(), duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

}
