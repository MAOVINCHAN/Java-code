package com.it.p1_socket2;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8888);

        new WriteThread(socket, "客户端").start();
        new ReadThread(socket).start();
    }
}
