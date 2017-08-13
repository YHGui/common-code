package com.katsura.concurrencyInJava7.chapter6.example7;

/**
 * Created by Katsura on 2017/4/16.
 */
public class Bank implements Runnable{
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.subtractAmount(1000);
        }
    }
}
