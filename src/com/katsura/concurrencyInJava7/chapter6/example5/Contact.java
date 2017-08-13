package com.katsura.concurrencyInJava7.chapter6.example5;

/**
 * Created by Katsura on 2017/4/16.
 */
public class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}
