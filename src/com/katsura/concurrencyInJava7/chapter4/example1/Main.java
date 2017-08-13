package com.katsura.concurrencyInJava7.chapter4.example1;

import java.util.Date;

/**
 * Created by Katsura on 2017/4/14.
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 100; i++) {
            Task task = new Task(new Date(),"Task " + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
