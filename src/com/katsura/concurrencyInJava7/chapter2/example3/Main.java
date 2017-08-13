package com.katsura.concurrencyInJava7.chapter2.example3;

/**
 * Created by Katsura on 2017/4/13.
 */
public class Main {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);
        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}
