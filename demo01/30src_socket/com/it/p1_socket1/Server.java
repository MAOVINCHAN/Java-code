package com.it.p1_socket1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        // 调用accept后服务器进入阻塞状态
        Socket socket = serverSocket.accept();

        // 服务器接收客户端第一次握手请求
        InputStream is = socket.getInputStream();
        byte[] message = new byte[1024];
        int read = is.read(message);
        System.out.println(new String(message, 0, read));

        // 模拟第二次握手
        OutputStream os = socket.getOutputStream();
        os.write("术尚可求".getBytes());
        Thread.sleep(1000);

        //服务器接收客户端第三次握手请求
        read = is.read(message);
        System.out.println(new String(message, 0, read));

        // 包验证成功，握手完成，可以连接

        // 关闭会话
        os.close();
        is.close();
        socket.close();
    }
}
