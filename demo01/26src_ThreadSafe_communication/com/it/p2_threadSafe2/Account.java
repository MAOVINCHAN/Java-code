package com.it.p2_threadSafe2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String ID;
    private double money;
    //方式三
    private Lock lock = new ReentrantLock();

    public Account(String ID, double money) {
        this.ID = ID;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID='" + ID + '\'' +
                ", money=" + money +
                '}';
    }

    //方式一
    // public synchronized void draw(double money) {
    //     String user = Thread.currentThread().getName();
    //     if(this.money >= money) {
    //         this.money -= money;
    //         System.out.println(user + "取出" + money + "成功！余额：" + this.money);
    //     }else {
    //         System.out.println(user + "取出" + money + "失败！余额不足。");
    //     }
    // }

    //方式二
    // public void draw(double money) {
    //     String user = Thread.currentThread().getName();
    //     synchronized (this) {
    //         if(this.money >= money) {
    //             this.money -= money;
    //             System.out.println(user + "取出" + money + "成功！余额：" + this.money);
    //         }else {
    //             System.out.println(user + "取出" + money + "失败！余额不足。");
    //         }
    //     }
    // }


    public void draw(double money) {
        String user = Thread.currentThread().getName();
        try {
            lock.lock(); // 上锁

            if(this.money >= money) {
                this.money -= money;
                System.out.println(user + "取出" + money + "成功！余额：" + this.money);
            }else {
                System.out.println(user + "取出" + money + "失败！余额不足。");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock(); // 解锁
        }
    }
}
