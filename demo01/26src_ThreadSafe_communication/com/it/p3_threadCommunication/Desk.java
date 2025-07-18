package com.it.p3_threadCommunication;

import java.util.ArrayList;

public class Desk {
    ArrayList<String> baozi = new ArrayList();

    // 厨师1，厨师2，厨师3，可能进入线程
    public synchronized void put() {
        String user = Thread.currentThread().getName();

        try {
            if(baozi.size() == 0) {
                baozi.add(user + "做的包子");

                System.out.println(user + "做了一个包子~");

                Thread.sleep(2000);
            }

            // 通知其他线程，自己进入等待
            /**
             * 注意1： 需要先唤醒notify其他线程，再自己进入等待wait，否则就是自己进入等待了无法再唤醒其他线程。
             * 注意2：notify和wait是Object身上的方法，任意对象都可以调用，但是一定要使用锁对象调用，否则会出bug。
             * 使用锁对象才知道等待/唤醒哪个线程。
             */
            this.notifyAll();
            this.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 吃货1，吃货2，可能进入线程
    public synchronized void get() {
        String user = Thread.currentThread().getName();

        try {
            if(baozi.size() == 1) {
                System.out.println(user + "吃了" + baozi.get(0));

                baozi.clear();

                Thread.sleep(1000);
            }

            this.notifyAll();
            this.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
