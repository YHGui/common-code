package com.katsura.multiThread.chapter1;

/**
 * Created by Katsura on 2017/4/6.
 */
public class BLogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}
