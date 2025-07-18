package com.it.p10_thread;

public class Test1 {
    public static void main(String[] args) {
        // 创建线程方式一
        Thread thread = new Thread(new Thread1());
        thread.start();

        // 创建线程方式二
        new Thread2().start();

        // 创建线程方式三
        new Thread() {
            @Override
            public void run() {
                System.out.println("thread3: " + this.getName());
            }
        }.start();

        // 创建线程方式四
        new Thread(() -> {
            System.out.println("thread4: ");
        }).start();
    }
}

class Thread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("thread1: " + Thread1.class);
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println("thread2: " + Thread2.currentThread().getName());
    }
}
