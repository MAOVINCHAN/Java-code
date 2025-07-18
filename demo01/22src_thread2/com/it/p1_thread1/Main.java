package com.it.p1_thread1;


// 调用线程的interrupt()方法，线程内的join()方法会立即抛出InterruptedException异常。
public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyTH1 myTH1 = new MyTH1();
        myTH1.start();
        Thread.sleep(1000);
        myTH1.interrupt();
        myTH1.join();
        System.out.println("end");
    }
}

class MyTH1 extends Thread {
    @Override
    public void run() {
        MyTh2 myTh2 = new MyTh2();
        myTh2.start();
        try {
            myTh2.join();
        } catch (InterruptedException e) {
            System.out.println("myth2 is interrupted");
        }
        myTh2.interrupt();
    }
}

class MyTh2 extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + "hello");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                break;
            }
        }
    }
}