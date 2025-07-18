package com.learn.demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer(); //1.创建字节码增强对象
        enhancer.setSuperclass(Dog.class); //2.设置父类（等价于实现原始类接口）
        enhancer.setCallback(
            /**
             * @param o 代理的对象
             * @param method 代理的方法
             * @param objects 方法的参数
             * @param methodProxy 代理的方法
             * @return 返回方法反射后调用返回的返回值
             */
            ((MethodInterceptor) (o, method, objects, methodProxy) -> {
                System.out.println("before...");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("after...");
                return result;
            }
        )); //3.设置回调函数（额外功能代码）
        Dog dog = (Dog) enhancer.create();
        dog.eat();
    }
}
