package com.katsura.concurrencyInJava7.chapter1.example12;

import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/12.
 */
public class Task implements Runnable{
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
