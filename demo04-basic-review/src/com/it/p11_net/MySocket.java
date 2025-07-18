package com.it.p11_net;

import java.io.*;
import java.net.Socket;
public class MySocket {
    String name;//用户名
    Socket socket;//客户端对象
    public MySocket(String name){
        //客户端
        this.name=name;
        Socket socket=null;
        try {
            socket = new Socket("127.0.0.1",8888);
            this.socket=socket;
            //单独开出一条线程用来打印
            Thread t=new Thread(new SocketRunable(socket));
            t.setName(name);
            t.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void talk(Socket socket,String str) {//与聊天界面的信息输入框和发送按钮绑定
        try {
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(str);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
class SocketRunable implements Runnable{
    Socket socket;
    public SocketRunable(Socket socket) {
        this.socket=socket;
    }
    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        while (true){
            try {
                BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str=br.readLine();
                //将反馈的信息打印到文本框中
                SocketJFrame.jTextArea.append(str+"\r\n");
                System.out.println(name+":"+str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}