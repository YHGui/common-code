package com.katsura.nio;


import org.junit.Test;

import java.nio.ByteBuffer;

public class TestBuffer {
    @Test
    public void test1() {
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("--------------allocate----------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        buffer.put(str.getBytes());

        System.out.println("--------------put----------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        buffer.flip();
        System.out.println("--------------flip----------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println("--------------get----------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        buffer.rewind();
        System.out.println("--------------rewind----------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        buffer.clear();
        System.out.println("--------------clear----------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

        System.out.println((char)buffer.get());
    }
}
