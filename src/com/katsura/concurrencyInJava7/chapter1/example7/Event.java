package com.katsura.concurrencyInJava7.chapter1.example7;

import java.util.Date;

/**
 * Created by Katsura on 2017/4/12.
 */
public class Event {
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
