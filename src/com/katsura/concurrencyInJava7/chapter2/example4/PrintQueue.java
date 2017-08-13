package com.katsura.concurrencyInJava7.chapter2.example4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Katsura on 2017/4/13.
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();
    public void printJob(Object document) {
        queueLock.lock();
        Long duration = (long)(Math.random() * 10000);
        System.out.printf(Thread.currentThread().getName() +
                        ":PrintQueue: Printing a Job during " + (duration / 1000) + " seconds\n");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
