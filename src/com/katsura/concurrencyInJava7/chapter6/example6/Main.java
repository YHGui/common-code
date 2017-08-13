package com.katsura.concurrencyInJava7.chapter6.example6;

/**
 * Created by Katsura on 2017/4/16.
 */
public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            TaskLocalRandom task = new TaskLocalRandom();
            threads[i] = new Thread(task);
            threads[i].start();
        }
    }
}
