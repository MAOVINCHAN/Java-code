package com.it.p12_my_net;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);

        new Thread(() -> {
            try {
                while (true) {
                    InputStream is = socket.getInputStream();
                    BufferedReader bri = new BufferedReader(new InputStreamReader(is));
                    String msg = bri.readLine();
                    System.out.println(msg);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        BufferedReader brs = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String msg = brs.readLine();
            OutputStream os = socket.getOutputStream();
            BufferedWriter bwo = new BufferedWriter(new OutputStreamWriter(os));
            bwo.write(msg);
            bwo.newLine();
            bwo.flush();
        }
    }
}
