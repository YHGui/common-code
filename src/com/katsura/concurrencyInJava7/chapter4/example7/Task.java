package com.katsura.concurrencyInJava7.chapter4.example7;

import java.util.Date;

/**
 * Created by Katsura on 2017/4/14.
 */
public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
    }
}
