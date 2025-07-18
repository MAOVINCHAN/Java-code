package com.it.p3_TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();

        DataInputStream dis = new DataInputStream(is);

        while (true) {
            String str = dis.readUTF();

            System.out.println("from client: " + str);
        }
    }
}