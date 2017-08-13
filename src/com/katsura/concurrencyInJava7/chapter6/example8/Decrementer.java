package com.katsura.concurrencyInJava7.chapter6.example8;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Katsura on 2017/4/16.
 */
public class Decrementer implements Runnable{
    private AtomicIntegerArray vector;

    public Decrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            vector.getAndDecrement(i);
        }
    }
}
