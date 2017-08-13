package com.katsura.concurrencyInJava7.chapter7.example6;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by Katsura on 2017/4/17.
 */
public class MyWorkThread extends ForkJoinWorkerThread{
    private static ThreadLocal<Integer> taskCounter = new ThreadLocal<Integer>();

    public MyWorkThread(ForkJoinPool pool) {
        super(pool);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.printf("MyWorkerThread %d: Initializing task counter.\n", getId());
        taskCounter.set(0);
    }

    @Override
    protected void onTermination(Throwable exception) {
        System.out.printf("MyWorkerThread %d: %d\n", getId(), taskCounter.get());
        super.onTermination(exception);
    }

    public void addTask(){
        int counter = taskCounter.get().intValue();
        counter++;
        taskCounter.set(counter);
    }
}
