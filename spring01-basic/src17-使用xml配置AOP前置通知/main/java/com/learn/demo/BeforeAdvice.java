package com.learn.demo;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String name = method.getName();
        System.out.println("--- " + name + " --- 开始执行");
    }
}
