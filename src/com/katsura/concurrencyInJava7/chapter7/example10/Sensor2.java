package com.katsura.concurrencyInJava7.chapter7.example10;

/**
 * Created by Katsura on 2017/4/17.
 */
public class Sensor2 implements Runnable{
    private ParkingCounter counter;

    public Sensor2(ParkingCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.carIn();
        counter.carOut();
        counter.carOut();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
        counter.carIn();
    }
}
