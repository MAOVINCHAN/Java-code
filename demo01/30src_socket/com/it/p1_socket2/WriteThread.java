package com.it.p1_socket2;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread{
    private Socket sc;
    private String name;
    private Scanner scanner = new Scanner(System.in);

    public WriteThread(Socket sc, String n) {
        this.sc = sc;
        this.name = n;
    }

    @Override
    public void run() {
        OutputStream os = null;
        try {
            os = sc.getOutputStream();

            while (true) {
                os.write((name + ":" + scanner.next()).getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeAll(os, scanner);
        }
    }
}
