package com.katsura.concurrencyInJava7.chapter1.example3;

/**
 * Created by Katsura on 2017/4/12.
 */
public class Main {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
