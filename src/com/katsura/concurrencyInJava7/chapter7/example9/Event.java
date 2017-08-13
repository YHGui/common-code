package com.katsura.concurrencyInJava7.chapter7.example9;

/**
 * Created by Katsura on 2017/4/17.
 */
public class Event implements Comparable<Event> {
    private String thread;
    private int priority;

    public Event(String thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }

    public String getThread() {
        return thread;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Event o) {
        if (this.priority > o.getPriority()) {
            return -1;
        } else if (this.priority < o.getPriority()){
            return 1;
        } else {
            return 0;
        }
    }
}
