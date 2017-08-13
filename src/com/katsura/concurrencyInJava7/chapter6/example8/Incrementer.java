package com.katsura.concurrencyInJava7.chapter6.example8;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Katsura on 2017/4/16.
 */
public class Incrementer implements Runnable{
    private AtomicIntegerArray vector;

    public Incrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            vector.getAndIncrement(i);
        }
    }
}
