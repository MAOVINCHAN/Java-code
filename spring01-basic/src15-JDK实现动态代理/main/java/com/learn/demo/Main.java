package com.learn.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 需求： 动态代理接口ICalculator，针对add方法，打印执行时间，针对其他方法，正常执行方法
 *
 * 实现方式：
 * 1. 基于JDK提供的代理,无需外部jar，使用Proxy类实现，只可以代理接口，不可以代理具体类
 * 2. 基于cglib提供的代理，需要外部jar，可以代理具体类
 */
public class Main {
    public static void main(String[] args) {
        // 1. new一个实现类
        ICalculatorImpl calculator = new ICalculatorImpl();
        // 2. 设置代理
        /**
         * 参数1：ClassLoader，所在类的ClassLoader
         * 参数2：要代理的接口，可以用数组写多个
         * 参数3：代理对象的具体实现，重写invoke方法
         */
        Class<?>[] interfaces = new Class[]{ICalculator.class};
        ICalculator proxyInstance = (ICalculator) Proxy.newProxyInstance(Main.class.getClassLoader(), interfaces, new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象本身
             * @param method 反射对象的方法的Class
             * @param args 执行方法的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();
                if(name.equals("add")) {
                    long start = System.nanoTime();
                    Object returnValue = method.invoke(calculator, args);
                    long end = System.nanoTime();
                    System.out.println("add方法执行消耗的时间是：" + (end - start) + "纳秒");
                    return returnValue;
                }
                return method.invoke(calculator, args);
            }
        });

        int value = proxyInstance.add(500, 2);
        System.out.println("value = " + value);

        proxyInstance.miu(9, 5);
    }
}
