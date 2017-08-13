package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class MyThread5 extends Thread{
    @Override
    public void run() {
        System.out.println("run = " + this.isAlive());
    }
}
