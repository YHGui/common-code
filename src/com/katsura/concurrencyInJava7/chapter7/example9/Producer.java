package com.katsura.concurrencyInJava7.chapter7.example9;

/**
 * Created by Katsura on 2017/4/17.
 */
public class Producer implements Runnable{
    private MyPriorityTransferQueue<Event> buffer;

    public Producer(MyPriorityTransferQueue<Event> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event(Thread.currentThread().getName(), i);
            buffer.put(event);
        }
    }
}
