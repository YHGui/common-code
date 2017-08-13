package com.katsura.concurrencyInJava7.chapter8.example1;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Katsura on 2017/4/17.
 */
public class MyLock extends ReentrantLock{
    public String getOwnerName() {
        if (this.getOwner() == null) {
            return "None";
        }
        return this.getOwner().getName();
    }
    public Collection<Thread> getThreads() {
        return this.getQueuedThreads();
    }
}
