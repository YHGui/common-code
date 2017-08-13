package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class ALogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}
