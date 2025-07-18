package com.it.p1_ThreadPool;

public class MyRunable implements Runnable{
    private String name;
    public MyRunable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行任务: " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
