package com.katsura.concurrencyInJava7.chapter4.example10;

import java.util.concurrent.CompletionService;

/**
 * Created by Katsura on 2017/4/14.
 */
public class ReportRequest implements Runnable{
    private String name;
    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    @Override
    public void run() {
        ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
        service.submit(reportGenerator);
    }
}
