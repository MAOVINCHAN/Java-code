package com.it.p1_socket2;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        new WriteThread(socket, "服务器").start();

        new ReadThread(socket).start();

    }
}
