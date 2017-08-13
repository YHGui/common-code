package com.katsura.concurrencyInJava7.chapter4.example9;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Katsura on 2017/4/14.
 */
public class ResultTask extends FutureTask<String> {
    private String name;

    public ResultTask(Callable<String> callable, String name) {
        super(callable);
        this.name = ((ExecutableTask)callable).getName();
    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been canceled\n", name);
        } else {
            System.out.printf("%s: Has finished\n", name);
        }
    }
}
