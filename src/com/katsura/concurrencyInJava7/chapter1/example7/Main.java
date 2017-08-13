package com.katsura.concurrencyInJava7.chapter1.example7;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Katsura on 2017/4/12.
 */
public class Main {
    public static void main(String[] args) {
       Deque<Event> deque = new ArrayDeque<>();
        WriterTask writer = new WriterTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }
        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
