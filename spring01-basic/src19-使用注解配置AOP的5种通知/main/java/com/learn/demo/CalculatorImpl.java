package com.learn.demo;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements ICalculator{
    @Override
    public int add(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
        return a + b;
    }

    @Override
    public void min(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a - b));
    }
}
