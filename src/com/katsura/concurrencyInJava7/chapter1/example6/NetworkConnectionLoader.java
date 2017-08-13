package com.katsura.concurrencyInJava7.chapter1.example6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/12.
 */
public class NetworkConnectionLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning network connection loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("network connection loading has finished: %s\n", new Date());
    }
}
