package com.it.p2_UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("请输入内容：");
            String str = scanner.next();

            if("exit".equals(str)) {
                System.out.println("退出成功！");
                ds.close();
                break;
            }

            byte[] bytes = str.getBytes();
            DatagramPacket pocket = new DatagramPacket(
                    bytes,
                    bytes.length,
                    InetAddress.getLocalHost(),
                    8888
            );

            ds.send(pocket);
        }
    }
}
