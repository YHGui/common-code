package com.katsura.goForJava.rpc.impl;

import com.katsura.goForJava.rpc.EchoService;

/**
 * Created by Katsura on 2017/6/27.
 */
public class EchoServiceImpl implements EchoService{
    @Override
    public String echo(String request) {
        return "echo : " + request;
    }
}
