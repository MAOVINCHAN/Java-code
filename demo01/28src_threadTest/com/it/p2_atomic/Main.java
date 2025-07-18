package com.it.p2_atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    count.incrementAndGet();
                }
            }
        };
        t1.start();


        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    count.decrementAndGet();
                }
            }
        };
        t2.start();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                count.incrementAndGet();
            }
        };
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(count.get());
    }
}
