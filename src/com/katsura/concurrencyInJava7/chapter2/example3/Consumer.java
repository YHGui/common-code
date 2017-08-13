package com.katsura.concurrencyInJava7.chapter2.example3;

/**
 * Created by Katsura on 2017/4/13.
 */
public class Consumer implements Runnable{
    private EventStorage storage;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }
}
