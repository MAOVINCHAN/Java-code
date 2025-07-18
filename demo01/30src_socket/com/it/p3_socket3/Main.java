package com.it.p3_socket3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Main {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("connected success at " + socket.getRemoteSocketAddress() + " / " + socket.getLocalAddress());
            new HandleThread(socket).start();
        }
    }
}

class HandleThread extends Thread {
    private Socket socket = null;

    public HandleThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                InputStream is = this.socket.getInputStream();
                OutputStream os = this.socket.getOutputStream();
                ) {
            handle(is, os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handle(InputStream is, OutputStream os) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

        String data =
        "<html>" +
            "<body>" +
                "<h1>Hello, world!</h1>" +
            "</body>" +
        "</html>";

        int length = data.getBytes(StandardCharsets.UTF_8).length;
        writer.write("HTTP/1.0 200 OK\r\n");
        writer.write("Connection: close\r\n");
        writer.write("Content-Type: text/html\r\n");
        writer.write("Content-Length: " + length + "\r\n");
        writer.write("\r\n"); // 空行标识Header和Body的分隔
        writer.write(data);
        writer.flush();
    }
}
