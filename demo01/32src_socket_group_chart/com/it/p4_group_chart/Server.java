package com.it.p4_group_chart;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket> onLines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("--- server running ---");

        while (true) {
            Socket socket = serverSocket.accept();

            onLines.add(socket);

            new ServerReadThread(socket).start();
        }
    }
}
