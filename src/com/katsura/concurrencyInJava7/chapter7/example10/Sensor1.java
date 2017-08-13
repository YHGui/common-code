package com.katsura.concurrencyInJava7.chapter7.example10;

/**
 * Created by Katsura on 2017/4/17.
 */
public class Sensor1 implements Runnable{
    private ParkingCounter counter;

    public Sensor1(ParkingCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carOut();
        counter.carOut();
        counter.carOut();
        counter.carIn();
        counter.carIn();
        counter.carIn();

    }
}
