package com.it.p3_async_task3;

import java.util.concurrent.CompletableFuture;

/**
 * 多个CompletableFuture串行执行
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 第一个任务
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            return getCode();
        });

        // cf成功后，返回第一个任务的结果并继续执行下一个任务，最后返回cf2
        CompletableFuture<Double> cf2 = cf.thenApplyAsync((lastResult) -> {
            System.out.println("lastResult: " + lastResult);

            return getPrice();
        });

        // cf2成功后打印结果
        cf2.thenAccept((finalResult) -> {
            System.out.println("finalResult: " + finalResult);
        });

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(3000);
    }

    private static double getPrice() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Math.random() * 10 + 1;
    }

    static String getCode() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        return "11111";
    }
}
