package com.katsura.concurrencyInJava7.chapter4.example11;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Katsura on 2017/4/14.
 */
public class RejectedTaskController implements RejectedExecutionHandler{
    //两个参数：一个Runnable对象，用来存储被拒绝的任务，一个Executor对象，用来存储任务被拒绝的执行器
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectedTaskController: The task %s has been rejected.\n", r.toString());
        System.out.printf("RejectedTaskController: %s\n", executor.toString());
        System.out.printf("RejectedTaskController: Terminating: %s\n", executor.isTerminated());
        System.out.printf("RejectedTaskController: Terminated: %s\n", executor.isTerminated());
    }
}
