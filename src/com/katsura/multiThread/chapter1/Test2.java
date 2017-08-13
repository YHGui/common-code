package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class Test2 {
    public static void main(String[] args) {
        MyThread2 t11 = new MyThread2(1);
        MyThread2 t12 = new MyThread2(2);
        MyThread2 t13 = new MyThread2(3);
        MyThread2 t14 = new MyThread2(4);
        MyThread2 t15 = new MyThread2(5);
        MyThread2 t16 = new MyThread2(6);
        MyThread2 t17 = new MyThread2(7);
        MyThread2 t18 = new MyThread2(8);
        MyThread2 t19 = new MyThread2(9);
        MyThread2 t110 = new MyThread2(10);
        MyThread2 t111 = new MyThread2(11);
        MyThread2 t112 = new MyThread2(12);
        MyThread2 t113 = new MyThread2(13);
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
        t16.start();
        t17.start();
        t18.start();
        t19.start();
        t110.start();
        t111.start();
        t112.start();
        t113.start();
    }
}
