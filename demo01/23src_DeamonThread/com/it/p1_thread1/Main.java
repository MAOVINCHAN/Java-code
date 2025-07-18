package com.it.p1_thread1;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Deamon守护线程
        // 主线程需要全部子线程关闭才能关闭，使用守护子线程后，主线程执行完可以正常关闭，但需注意守护线程内不能持有任何需要关闭的资源，例如打开文件等；
        // 因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失。
        Thread thread = new Thread(new DeamonTest());
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100000);
    }
}

class DeamonTest implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}