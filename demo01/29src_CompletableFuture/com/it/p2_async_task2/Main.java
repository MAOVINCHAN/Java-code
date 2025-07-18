package com.it.p2_async_task2;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture.supplyAsync(Main::fetchPrice); 传入一个异步操作
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Object> cf = CompletableFuture.supplyAsync(Main::fetchPrice);

        // 异步方法执行成功的回调
        cf.thenAccept((res) -> {
            System.out.println(res);
        });

        // 异步方法执行失败的回调
        cf.exceptionally((err) -> {
            err.printStackTrace();
            return null;
        });

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(1000);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
