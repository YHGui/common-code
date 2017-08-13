package com.katsura.concurrencyInJava7.chapter2.example6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Katsura on 2017/4/13.
 */
public class PrintQueue {
    private Lock queueLock = new ReentrantLock(false);
    public void printJob(Object document) {
        try {
            queueLock.lock();
            Long duration = (long)(Math.random() * 10000);
            System.out.printf(Thread.currentThread().getName() +
                    ":PrintQueue: Printing a Job during " + (duration / 1000) + " seconds\n");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
        queueLock.lock();
        try {
            Long duration = (long)(Math.random() * 10000);
            System.out.printf(Thread.currentThread().getName() +
                    ":PrintQueue: Printing a Job during " + (duration / 1000) + " seconds\n");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
