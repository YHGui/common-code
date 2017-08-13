package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class Run2 {
    public static void main(String[] args) {
        MyThread3 a = new MyThread3("A");
        MyThread3 b = new MyThread3("B");
        MyThread3 c = new MyThread3("C");
        a.start();
        b.start();
        c.start();
    }
}
