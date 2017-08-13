package com.katsura.concurrencyInJava7.chapter4.example10;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/14.
 */
public class ReportProcessor implements Runnable{
    private CompletionService<String> service;
    private boolean end;

    public ReportProcessor(CompletionService<String> service) {
        end = false;
        this.service = service;
    }

    @Override
    public void run() {
        while (!end) {
            try {
                //获取下一个已经完成任务的Future对象
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                if (result != null) {
                    //get()获取任务的结果
                    String report = result.get();
                    System.out.printf("ReportService: Report Received: %s\n", report);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("ReportSender: End\n");
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
