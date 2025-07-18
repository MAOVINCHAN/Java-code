package com.it.p1_socket1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8888);

        // 模拟第一次握手
        OutputStream os = socket.getOutputStream();
        os.write("有道无术".getBytes());
        Thread.sleep(1000);

        // 客户器接收服务端第二次握手请求
        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b, 0, len));
        Thread.sleep(1000);

        // 模拟第三次握手
        os.write("有道无术,术尚可求".getBytes());

        //关闭会话
        os.close();
        is.close();
        socket.close();
    }
}
