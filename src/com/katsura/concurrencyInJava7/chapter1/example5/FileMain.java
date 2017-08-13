package com.katsura.concurrencyInJava7.chapter1.example5;

import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/12.
 */
public class FileMain {
    public static void main(String[] args) {
        FileClock fileClock = new FileClock();
        Thread thread = new Thread(fileClock);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
