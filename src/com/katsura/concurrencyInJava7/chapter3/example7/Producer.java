package com.katsura.concurrencyInJava7.chapter3.example7;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by Katsura on 2017/4/13.
 */
public class Producer implements Runnable{
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Producer: Cycle %d\n", cycle);
            for (int j = 0; j < 10; j++) {
                String message = "Event " + (i * 10 + j);
                buffer.add(message);
            }
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Producer: " + buffer.size());
            cycle++;
        }
    }
}
