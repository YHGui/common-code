package com.katsura.concurrencyInJava7.chapter3.example6;

/**
 * Created by Katsura on 2017/4/13.
 */
public class Main {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser();
        Student[] students = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(myPhaser);
            myPhaser.register();
        }
        Thread[] threads = new Thread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new Thread(students[i], "Student " + i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: The phaser has finished: %s.\n", myPhaser.isTerminated());
    }
}
