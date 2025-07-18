package com.it.p1_threadSafe;

public class Test1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1("线程1");
        myThread1.start();

        MyThread2 myThread2 = new MyThread2("线程2");
        myThread2.start();
    }
}

class Resouce {
    public static int count = 0;
}

class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Resouce.count += i;
        }
    }
}

class MyThread2 extends Thread {
    public MyThread2(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Resouce.count -= i;
        }
    }
}
