package com.katsura.concurrencyInJava7.chapter1.example2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Katsura on 2017/4/12.
 */
public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State status[] = new Thread.State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }
        try (FileWriter file = new FileWriter("D:\\concurrency\\thread.log");
            PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < threads.length; i++) {
                Thread thread = threads[i];
                pw.println("Solution: Status of Thread " + i +
                            " : " +threads[i].getState());
            }
            for (int i = 0; i < threads.length; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < threads.length; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < threads.length; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Solution : Id %d - %s", thread.getId(), thread.getName());
        pw.println();
        pw.printf("Solution : Priority : %d", thread.getPriority());
        pw.println();
        pw.printf("Solution : Old State : %s", state);
        pw.println();
        pw.printf("Solution : New State : %s", thread.getState());
        pw.println();
        pw.printf("Solution : **************************");
        pw.println();
    }
}
