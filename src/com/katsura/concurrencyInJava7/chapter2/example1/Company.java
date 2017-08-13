package com.katsura.concurrencyInJava7.chapter2.example1;

/**
 * Created by Katsura on 2017/4/12.
 */
public class Company implements Runnable{
    private Account account;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
        }
    }

    public Company(Account account) {
        this.account = account;
    }
}
