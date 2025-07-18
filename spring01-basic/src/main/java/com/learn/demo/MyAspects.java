package com.learn.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class MyAspects {
    @Pointcut("execution(* com.learn.demo.CalculatorImpl.*(..))")
    public void pointcut(){};

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行了");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            String name = proceedingJoinPoint.getSignature().getName();
            System.out.println(name + "方法环绕前通知");
            Object proceed = proceedingJoinPoint.proceed();
            System.out.println(name + "方法环绕后通知");
            return proceed;
        } catch (Throwable e) {
            // 异常通知
            e.printStackTrace();
        }
        return null;
    }

    @After("pointcut()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束了");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "res")
    public void returning(JoinPoint jp, Object res) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行后的返回值为：" + res);
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "err")
    public void throwing(JoinPoint jp, Exception err) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行后抛出的错误信息为：" + err.getMessage());
    }
}
