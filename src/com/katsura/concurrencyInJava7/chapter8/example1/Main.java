package com.katsura.concurrencyInJava7.chapter8.example1;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/17.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        MyLock lock = new MyLock();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Task task = new Task(lock);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (int i = 0; i < 15; i++) {
            System.out.printf("Main: Logging the Lock.\n");
            System.out.printf("*************************\n");
            System.out.printf("Lock: Owner : %s\n", lock.getOwnerName());
            System.out.printf("Lock: Queued Threads: %s\n", lock.hasQueuedThreads());
            if (lock.hasQueuedThreads()) {
                System.out.printf("Lock: Queue Length: %d\n", lock.getQueueLength());
                System.out.printf("Lock: Queue Threads: ");
                Collection<Thread> lockedThreads = lock.getThreads();
                for (Thread lockThread : lockedThreads) {
                    System.out.printf("%s ", lockThread.getName());
                }
                System.out.printf("\n");
            }
            System.out.printf("Lock: Fairness: %s\n", lock.isFair());
            System.out.printf("Lock: Locked: %s\n", lock.isLocked());
            System.out.printf("***********************************\n");
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
