package com.katsura.concurrencyInJava7.chapter6.example1;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Katsura on 2017/4/16.
 */
public class PollTask implements Runnable{
    private ConcurrentLinkedDeque<String> list;
    //private ArrayList<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }
//    public PollTask(ArrayList<String> list) {
//        this.list = list;
//    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
//            list.remove(list.size() - 1);
//            list.remove(list.size() - 1);
        }
    }
}
