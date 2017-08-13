package com.katsura.concurrencyInJava7.chapter5.example5;

import java.util.Random;

/**
 * Created by Katsura on 2017/4/16.
 */
public class ArrayGenerator {
    public int[] generateArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
