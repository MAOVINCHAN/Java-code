package com.it.p1_UDP;

import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        // 创建数据包对象封装要发送的数据
        // DatagramPacket(
        //  byte buf[],  // 要发送的数据，字节数组
        //  int offset,  // 偏移量
        //  int length, // 数据大小，字节个数length
        //  InetAddress address, // 服务器的IP地址
        //  int port // 端口
        // )

        byte[] str = "要发送的数据".getBytes();
        DatagramPacket pocket = new DatagramPacket(
                str,
                str.length,
                InetAddress.getLocalHost(),
                888
        );
    }
}
