package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class Run6 {
    public static void main(String[] args)  throws InterruptedException{
        MyThread5 myThread5 = new MyThread5();
//        isAlive()判断是否处于活动状态
        System.out.println("begin == " + myThread5.isAlive());
        myThread5.start();
        //true代表线程还未执行完毕
        Thread.sleep(1000);
        System.out.println("end == " + myThread5.isAlive());
    }

}
