package com.katsura.concurrencyInJava7.chapter7.example4;

import java.util.Date;

/**
 * Created by Katsura on 2017/4/17.
 */
public class MyThread extends Thread{
    private Date creationDate;
    private Date startDate;
    private Date finishDate;

    public MyThread(Runnable target, String name) {
        super(target, name);
        setCreationDate();
    }

    public void setCreationDate() {
        creationDate = new Date();
    }

    public void setStartDate() {
        startDate = new Date();
    }

    public void setFinishDate() {
        finishDate = new Date();
    }

    public long getExecutionTime() {
        return finishDate.getTime() - startDate.getTime();
    }

    @Override
    public void run() {
        setStartDate();
        super.run();
        setFinishDate();
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(getName());
        buffer.append(": ");
        buffer.append(" Creation Date: ");
        buffer.append(creationDate);
        buffer.append(" : Running time: ");
        buffer.append(getExecutionTime());
        buffer.append(" Milliseconds.");
        return buffer.toString();
    }
}
