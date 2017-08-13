package com.katsura.concurrencyInJava7.chapter5.example1;

/**
 * Created by Katsura on 2017/4/16.
 */
public class Product {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
