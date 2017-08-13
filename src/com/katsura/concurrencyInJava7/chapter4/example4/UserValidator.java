package com.katsura.concurrencyInJava7.chapter4.example4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Katsura on 2017/4/14.
 */
public class UserValidator {
    private String name;

    public UserValidator(String name) {
        this.name = name;
    }
    public boolean validate(String name, String password) {
        Random random = new Random();
        long duration = (long) (Math.random() * 10);
        System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextBoolean();
    }

    public String getName() {
        return name;
    }
}
