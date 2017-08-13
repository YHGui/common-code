package com.katsura.concurrencyInJava7.chapter2.example3;

/**
 * Created by Katsura on 2017/4/13.
 */
public class Producer implements Runnable{
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
