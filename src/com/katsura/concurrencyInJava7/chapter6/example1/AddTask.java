package com.katsura.concurrencyInJava7.chapter6.example1;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Katsura on 2017/4/16.
 */
public class AddTask implements Runnable{
    private ConcurrentLinkedDeque<String> list;
    //private ArrayList<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }
//    public AddTask(ArrayList<String> list) {
//        this.list = list;
//    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ": Element " + i);
        }
    }
}
