package com.katsura.concurrencyInJava7.chapter7.example3;

/**
 * Created by Katsura on 2017/4/17.
 */
public class Main {
    public static void main(String[] args) {
        MyThreadFactory myFactory = new MyThreadFactory("MyThreadFactory");
        MyTask task = new MyTask();
        Thread thread = myFactory.newThread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Solution: Thread information.\n");
        System.out.printf("%s\n", thread);
        System.out.printf("Solution: End of the example.\n");
    }
}
