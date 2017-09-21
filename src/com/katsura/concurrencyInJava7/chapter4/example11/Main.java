package com.katsura.concurrencyInJava7.chapter4.example11;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Katsura on 2017/4/14.
 */
public class Main {
    public static void main(String[] args) {
        RejectedTaskController controller = new RejectedTaskController();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(controller);
        System.out.printf("Solution: Starting.\n");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task " + i);
            executor.submit(task);
        }
        System.out.printf("Solution: Shutting down the Executor");
        executor.shutdown();

        System.out.printf("Solution: Sending another Task.\n");
        Task task = new Task("RejectedTask");
        executor.submit(task);
        System.out.println("Solution: End");
        System.out.printf("Solution: End\n");
    }
}
