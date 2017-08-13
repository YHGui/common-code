package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class Run1 {
    public static void main(String[] args) {
        //不仅可以传入Runnable实例，还可以传入Thread实例，因此完全可以将一个Thread对象中的run方法交由其他线程调用
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束！");
    }
}
