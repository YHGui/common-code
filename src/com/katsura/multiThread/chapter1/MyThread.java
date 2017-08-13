package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
