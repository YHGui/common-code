package com.katsura.concurrencyInJava7.chapter3.example7;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by Katsura on 2017/4/13.
 */
public class Consumer implements Runnable{
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer: Cycle %d\n", cycle);
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Consumer: " + buffer.size() + "\n");
            for (int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.println("Consumer: " + message + "\n");
                buffer.remove(0);
            }
            cycle++;
        }
    }
}
