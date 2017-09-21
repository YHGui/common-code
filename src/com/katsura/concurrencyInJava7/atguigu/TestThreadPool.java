package com.katsura.concurrencyInJava7.atguigu;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) throws  Exception {

        ThreadPoolDemo tpd = new ThreadPoolDemo();

        ExecutorService pool =  Executors.newFixedThreadPool(5);

//        for (int i = 0; i < 10; i++) {
//            pool.submit(tpd);
//        }
//
//        pool.shutdown();

        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<Integer> future = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call()  {
                    int sum = 0;
                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                    }

                    return sum;
                }
            });

            list.add(future);
        }

        pool.shutdown();

        for(Future<Integer> future : list) {
            System.out.println(future.get());
        }
    }
}

class ThreadPoolDemo implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (i <= 100) {
            System.out.println(Thread.currentThread().getName() + ": " + i++);
        }
    }
}