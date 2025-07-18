package com.it.p3_timeout_test;

import java.util.concurrent.*;

/**
 * FixedRate是指任务总是以固定时间间隔触发，不管任务执行多长时间：
 * FixedDelay是指，上一次任务执行完毕后，等待固定的时间间隔，再执行下一次任务：
 */
public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        System.out.println("1111");
        // 任务延时1秒执行
        ses.schedule(new MyTask("1"), 1000, TimeUnit.MILLISECONDS);

        // 任务定时执行,首次延时1秒后，固定每2秒执行一次
        // 无论任务是否执行完成，达到固定的每2秒时间后就会执行一次
        ses.scheduleAtFixedRate(new MyTask("2"), 1000, 2000, TimeUnit.MILLISECONDS);

        // 任务定时执行，首次延时1秒后，固定每2秒执行一次
        // 上一次任务执行完毕后，等待固定的时间间隔，再执行下一次任务
        ses.scheduleWithFixedDelay(new MyTask("3"), 1000, 2000, TimeUnit.MILLISECONDS);
    }
}

class MyTask implements Runnable {
    private String name;
    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " running!");
    }
}
