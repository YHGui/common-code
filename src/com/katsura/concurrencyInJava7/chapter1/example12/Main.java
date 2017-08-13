package com.katsura.concurrencyInJava7.chapter1.example12;

/**
 * Created by Katsura on 2017/4/12.
 */
public class Main {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        Thread thread;
        System.out.printf("Starting the Threads\n");
        for (int i = 0; i < 10; i++) {
            thread = myThreadFactory.newThread(task);
            thread.start();
        }
        System.out.printf("Factory stats: \n");
        System.out.printf("%s\n", myThreadFactory.getStats());
    }
}
