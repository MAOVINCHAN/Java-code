package com.learn.demo;

public class CalculatorImpl implements ICalculator{
    @Override
    public int add(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
        return a + b;
    }

    @Override
    public void minus(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a - b));
    }
}
