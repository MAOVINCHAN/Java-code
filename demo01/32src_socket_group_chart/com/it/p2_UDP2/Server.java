package com.it.p2_UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        System.out.println("--- server running ---");

        // 创建数据包对象封装要接收的数据
        byte[] buffer = new byte[1024 * 64];

        DatagramPacket pocket = new DatagramPacket(buffer, buffer.length);

        while (true) {
            // 使用数据包接受数据
            socket.receive(pocket);
            //打印
            int len = pocket.getLength();

            System.out.println("收到客户端消息：" + new String(buffer, 0, len));
        }
    }
}
