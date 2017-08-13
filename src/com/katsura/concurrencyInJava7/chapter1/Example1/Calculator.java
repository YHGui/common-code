package com.katsura.concurrencyInJava7.chapter1.Example1;

/**
 * Created by Katsura on 2017/4/12.
 */
public class Calculator implements Runnable{
    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
        }
    }
}
