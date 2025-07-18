package com.it.p1_socket2;

import java.io.InputStream;
import java.net.Socket;

public class ReadThread extends Thread{
    private Socket sc;

    public ReadThread(Socket sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        InputStream is = null;
        try {
            is = sc.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while (true) {
                len = is.read(b);
                System.out.println(new String(b, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeAll(is);
        }
    }
}
