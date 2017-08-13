package com.katsura.concurrencyInJava7.chapter6.example7;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Katsura on 2017/4/16.
 */
public class Account {
    private AtomicLong balance;

    public Account() {
        balance = new AtomicLong();
    }
    public long getBalance() {
        return balance.get();
    }
    public void setBalance(long balance) {
        this.balance.set(balance);
    }
    public void addAmount(long amount) {
        this.balance.getAndAdd(amount);
    }
    public void subtractAmount(long amount) {
        this.balance.getAndAdd(-amount);
    }
}
