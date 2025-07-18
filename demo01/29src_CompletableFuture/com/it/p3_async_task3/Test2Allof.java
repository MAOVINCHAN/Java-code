package com.it.p3_async_task3;

import java.util.concurrent.CompletableFuture;

public class Test2Allof {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> scf1 = CompletableFuture.supplyAsync(() -> {
            return queryCode(Math.random() * 10);
        });

        CompletableFuture<String> scf2 = CompletableFuture.supplyAsync(() -> {
            return queryCode(Math.random() * 10);
        });

        // 返回的结果为null
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(scf1, scf2);

        // 全部异步任务执行成功的回调
        voidCompletableFuture.thenAccept((res) -> {
            System.out.println("res is: " + res); // 结果为null
        });

        // 有一个异步任务失败执行的回调
        voidCompletableFuture.exceptionally((err) -> {
            System.out.println("执行失败了");
            err.printStackTrace();
            return null;
        });

        Thread.sleep(3000);
    }

    private static String queryPrice(String code, String origin) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return code + Math.random() * 10 + origin;
    }

    private static <U> String queryCode(double time) {
        double num = Math.random() * 10;

        try {
            Thread.sleep(300);

            if(num < 3) {
                throw new RuntimeException();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "" + num;
    }
}
