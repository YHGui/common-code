package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class Run3 {
    public static void main(String[] args) {
//        某些JVM中，i--操作分为以下三步：
//        取得原i值，计算i-1，对i进行赋值
        MyThread4 myThread = new MyThread4();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");
        Thread e = new Thread(myThread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
