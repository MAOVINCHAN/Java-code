package com.learn.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect // 表示这是一个切面
@Component // 注册到spring容器
@EnableAspectJAutoProxy // 开启自动代理
public class MyAspects2 {
    // 定义一个切入点
    @Pointcut("execution(* com.learn.demo.CalculatorImpl.*(..))")
    public void pc() {}; // 空实现

    @Before("pc()")
    public void my_before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "开始执行了");
    }

    @Around("pc()")
    public Object my_around(ProceedingJoinPoint pjp) {
        try {
            // pjp.proceed();之前的为前置通知
            Object proceed = pjp.proceed(); // 相当于method.invoke
            // pjp.proceed();之后的为后置通知
            return proceed;
        } catch (Throwable e) {
            e.printStackTrace();
            // 异常通知
        }
        return null;
    }

    @After("pc()")
    public void my_after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "执行结束了");
    }

    @AfterReturning(value = "pc()", returning = "res")
    public void my_returning(JoinPoint jp, Object res) {
        String name = jp.getSignature().getName();
        System.out.println(name + "执行后的返回值为： " + res);
    }

    @AfterThrowing(value = "pc()", throwing = "err")
    public void my_throwing(JoinPoint jp, Exception err) {
        String name = jp.getSignature().getName();
        System.out.println(name + "报错了，抛出异常信息：" + err.getMessage());
    }
}
