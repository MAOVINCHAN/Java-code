package com.it.p11_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServerSocket {
    //记录连接的客户端
    static ArrayList<Socket> sockets = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //服务端
        ServerSocket ss = new ServerSocket(8888);
        //来一个客户端就开辟一个线程处理
        while (true) {
            Socket socket = ss.accept();
            sockets.add(socket);
            new Thread(new ServerRunable(socket, sockets)).start();
        }
    }
}
class ServerRunable implements Runnable {
    Socket socket;//连接处理的Socket
    ArrayList<Socket> sockets;
    public ServerRunable(Socket socket, ArrayList<Socket> sockets) {
        this.socket = socket;
        this.sockets = sockets;
    }
    @Override
    public void run() {
        //接收客户端发送的消息，并反馈
        while (true) {
            try {
                BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str=br.readLine();
                for (Socket socket1 : sockets) {//反馈给每一个客户端
                    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
                    bw.write(str);
                    bw.newLine();
                    bw.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}