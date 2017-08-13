package com.katsura.concurrencyInJava7.chapter6.example2;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Katsura on 2017/4/16.
 */
public class Main {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);
        Client client = new Client(list);
        Thread thread = new Thread(client);
        thread.start();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    String request = list.take();
                    System.out.printf("Main: Request: %s at %s. Size: %d\n", request, new Date(), list.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.printf("Main: End of the program.\n");
    }
}
