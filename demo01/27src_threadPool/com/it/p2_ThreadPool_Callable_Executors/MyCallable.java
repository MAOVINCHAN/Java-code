package com.it.p2_ThreadPool_Callable_Executors;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call(){
        int count = 0;
        for (int i = 1; i <= this.n; i++) {
            count += i;
        }
        return Thread.currentThread().getName() + "计算的结果是：" + count;
    }
}
