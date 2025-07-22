package com.learn.demo;

// import java.lang.reflect.InvocationHandler;
// import java.lang.reflect.Method;
// import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Main{
    public static void main(String[] args) {
        // ICalculator calculator = new CalculatorImpl();
        // Class<?>[] cs = new Class[]{ICalculator.class}; // 仅可代理接口
        // ICalculator obj = (ICalculator) Proxy.newProxyInstance(Main.class.getClassLoader(), cs, new InvocationHandler() {
        //     @Override
        //     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //         System.out.println(method.getName() + "开始执行");
        //         Object invoke = method.invoke(calculator, args); // 这里传入接口实现的对象
        //         System.out.println(method.getName() + "执行完毕");
        //         return invoke;
        //     }
        // });
        // obj.add(5,7);


        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CalculatorImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println(method.getName() + "开始执行");
                Object o = proxy.invokeSuper(obj, args);
                System.out.println(method.getName() + "执行完毕");
                return o;
            }
        });
        ICalculator obj = (ICalculator) enhancer.create();
        obj.add(7,8);
    }
}