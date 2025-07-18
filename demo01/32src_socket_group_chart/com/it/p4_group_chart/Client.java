package com.it.p4_group_chart;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);

        new ClientReadThread(socket).start();

        OutputStream os = socket.getOutputStream();

        DataOutputStream dos = new DataOutputStream(os);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("输入内容：");
            String str = scanner.next();

            if("exit".equals(str)) {
                System.out.println("退出成功！");
                socket.close();
                dos.close();
                break;
            }

            dos.writeUTF(str);
        }
    }
}
