package com.it.p12_my_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    public static List<Socket> clients = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int port = 8888;
        ServerSocket ss = new ServerSocket(port);
        System.out.println("server is running at port: " + port);
        while (true) {
            Socket socket = ss.accept();
            clients.add(socket);
            new ServerThread(socket,clients).start();
        }
    }
}

class ServerThread extends Thread {
    Socket socket;
    List<Socket> clients;
    BufferedWriter bw;
    BufferedReader br;

    public ServerThread(Socket socket, List<Socket> clients) throws IOException {
        this.socket = socket;
        this.clients = clients;
        this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String name;
            while (true) {
                sendMsgToClient("输入用户名以加入群聊：");
                name = br.readLine();
                if(name != null) {
                    break;
                }
            }

            String user = name + "[" + this.socket.getInetAddress().getHostAddress() + "]";
            sendMsgToClients("welcome " + user + " 加入聊天室", false);

            while (true) {
                String msg = br.readLine();
                sendMsgToClients(user + ": " + msg, true);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMsgToClient(String msg) throws IOException {
        this.bw.write(msg);
        this.bw.newLine();
        this.bw.flush();
    }

    /**
     * @param msg 消息
     * @param shieldSelf 消息是否发送给自己
     * @throws IOException
     */
    public void sendMsgToClients(String msg, boolean shieldSelf) throws IOException {
        for (Socket socket :
                clients) {
            if(shieldSelf && socket == this.socket) continue;
            OutputStream os = socket.getOutputStream();
            BufferedWriter bwo = new BufferedWriter(new OutputStreamWriter(os));
            bwo.write(msg);
            bwo.newLine();
            bwo.flush();
        }
    }
}