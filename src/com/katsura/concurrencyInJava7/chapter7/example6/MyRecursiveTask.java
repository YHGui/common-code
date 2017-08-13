package com.katsura.concurrencyInJava7.chapter7.example6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/17.
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {
    private int[] array;
    private int start, end;

    public MyRecursiveTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        Integer ret;
        MyWorkThread thread = (MyWorkThread) Thread.currentThread();
        thread.addTask();
        if (end - start < 2) {
            ret = array[start];
        } else {
            int mid = start + (end - start) / 2;
            MyRecursiveTask task1 = new MyRecursiveTask(array, start, mid);
            MyRecursiveTask task2 = new MyRecursiveTask(array, mid, end);
            invokeAll(task1, task2);
            ret = addResults(task1, task2);
        }
        return ret;

    }
    private Integer addResults(MyRecursiveTask task1, MyRecursiveTask task2) {
        int value;
        try {
            value = task1.get().intValue() + task2.get().intValue();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            value = 0;
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }
}
