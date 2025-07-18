package com.learn.demo;

public class ICalculatorImpl implements ICalculator{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public void miu(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a - b));
    }
}
