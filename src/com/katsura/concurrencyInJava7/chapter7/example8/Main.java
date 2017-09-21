package com.katsura.concurrencyInJava7.chapter7.example8;

import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/17.
 */
public class Main {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        for (int i = 0; i < 10; i++) {
            Task task = new Task(lock, "Task-" + i);
            Thread thread = new Thread(task);
            thread.start();
        }
        boolean value;
        do {
            try {
                value = lock.tryLock(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                value = false;
            }
        } while (!value);
        System.out.printf("Solution: Got the lock\n");
        lock.unlock();
        System.out.printf("Solution: End of the program.\n");
    }
}
