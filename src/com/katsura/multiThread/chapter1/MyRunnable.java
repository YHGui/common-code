package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("运行中！");
    }
}
