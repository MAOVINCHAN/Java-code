package com.it.p3_async_task3;

import java.util.concurrent.CompletableFuture;

public class Test1Anyof {
    public static void main(String[] args) throws InterruptedException {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            return queryCode(Math.random() * 10 + Math.random() * 5);
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            return queryCode(Math.random() * 10 + Math.random() * 5);
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfAny = CompletableFuture.anyOf(cf1, cf2);

        // 用anyOf合并后的CompletableFuture执行2个异步查询:
        CompletableFuture<String> any1 = cfAny.thenApplyAsync((code) -> {
            return queryPrice((String) code, "aaa");
        });

        CompletableFuture<String> any2 = cfAny.thenApplyAsync((code) -> {
            return queryPrice((String) code, "bbb");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> anys = CompletableFuture.anyOf(any1, any2);

        // 最终结果:
        anys.thenAccept((result) -> {
            System.out.println("result: " + result);
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
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "" + Math.random() * 10;
    }
}
