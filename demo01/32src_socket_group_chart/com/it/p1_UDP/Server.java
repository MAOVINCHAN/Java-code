package com.it.p1_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        // 创建数据包对象封装要接收的数据
        byte[] buffter = new byte[1024 * 64];
        DatagramPacket pocket = new DatagramPacket(buffter, buffter.length);

        // 使用数据包接受数据
        socket.receive(pocket);

        //打印
        int len = pocket.getLength();
    }
}
