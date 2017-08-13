package com.katsura.concurrencyInJava7.chapter7.example8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by Katsura on 2017/4/17.
 */
public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {
    private AtomicInteger state;

    public MyAbstractQueuedSynchronizer() {
        state = new AtomicInteger(0);
    }

    @Override
    protected boolean tryAcquire(int arg) {
        //0->1
        return state.compareAndSet(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        //1->0
        return state.compareAndSet(1, 0);
    }
}
