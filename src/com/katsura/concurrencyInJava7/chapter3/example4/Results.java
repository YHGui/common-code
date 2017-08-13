package com.katsura.concurrencyInJava7.chapter3.example4;

/**
 * Created by Katsura on 2017/4/13.
 */
public class Results {
    private int[] data;
    public Results(int size) {
        data = new int[size];
    }
    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
