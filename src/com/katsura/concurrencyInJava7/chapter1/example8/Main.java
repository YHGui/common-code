package com.katsura.concurrencyInJava7.chapter1.example8;

/**
 * Created by Katsura on 2017/4/12.
 */
public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
