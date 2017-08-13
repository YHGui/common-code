package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class MyThread4 extends Thread{
    private int count = 5;

    //synchronized关键字，加锁的代码称为互斥区或临界区
    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由 " + this.currentThread().getName() + " 计算，count = " + count);
    }
}
