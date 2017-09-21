package com.katsura.concurrencyInJava7.chapter4.example8;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/14.
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task = new Task();
        System.out.printf("Solution: Executing the Task\n");
        Future<String> result = executor.submit(task);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Solution: Canceling the Task\n");
        result.cancel(true);
        System.out.printf("Solution: Cancelled: %s\n", result.isCancelled());
        System.out.printf("Solution: Done: %s\n", result.isDone());
        executor.shutdown();
        System.out.printf("Solution: The executor has finished\n");
    }
}
