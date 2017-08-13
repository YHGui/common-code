package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class CountOperate extends Thread{
    public CountOperate() {
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        //为什么this.getName()的输出为Thread-0？
//        由于还没有设置名字setName(),因此自定义生成名字Thread-0
        System.out.println("this.getName = " + this.getName());
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("this.getName = " + this.getName());
        System.out.println("run---end");
    }
}
