package com.it.p4_group_chart;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientReadThread extends Thread{
    private final Socket socket;

    public ClientReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();

            DataInputStream dis = new DataInputStream(is);

            SocketAddress ip = socket.getRemoteSocketAddress();

            while (true) {
                try {
                    String msg = dis.readUTF();

                    System.out.println(msg);
                } catch (IOException e) {
                    String msg = "用户" + ip + "下线了。";

                    System.out.println(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
