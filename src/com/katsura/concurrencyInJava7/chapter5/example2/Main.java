package com.katsura.concurrencyInJava7.chapter5.example2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/16.
 */
public class Main {
    public static void main(String[] args) {
        DocumentMock mock = new DocumentMock();
        String[][] document = mock.generateDocument(100, 1000, "the");
        DocumentTask task = new DocumentTask(document, 0, 100, "the");
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);
        do {
            System.out.printf("*************************************\n");
            System.out.printf("Solution: Parallelisms: %d\n", pool.getParallelism());
            System.out.printf("Solution: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Solution: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Solution: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("**************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!task.isDone());
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.printf("Solution: The word appears %d in the document", task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
