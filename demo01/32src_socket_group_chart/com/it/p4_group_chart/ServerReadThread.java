package com.it.p4_group_chart;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerReadThread extends Thread{
    private final Socket socket;

    public ServerReadThread(Socket socket) {
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
                    String str = dis.readUTF();

                    String msg = "收到来自" + ip + "的新消息：" + str;

                    sendMsgToAll(msg);
                } catch (IOException e) {
                    e.printStackTrace();

                    String msg = "用户" + ip + "下线了。";

                    sendMsgToAll(msg);

                    Server.onLines.remove(socket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMsgToAll(String msg) throws IOException {
        for (Socket onLine : Server.onLines) {
            OutputStream os = onLine.getOutputStream();

            DataOutputStream dos = new DataOutputStream(os);

            dos.writeUTF(msg);
        }
    }
}
