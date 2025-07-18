package com.learn.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspects {
    private Long start;
    // 自定义前置通知
    public void my_before(JoinPoint jp) {
        String method_name = jp.getSignature().getName();
        start = System.nanoTime();
        System.out.println(method_name + " 开始执行了");
    }

    // 自定义后置通知
    public void my_after(JoinPoint jp) {
        String method_name = jp.getSignature().getName();
        long end = System.nanoTime();
        System.out.println(method_name + " 执行结束了，总耗时：" + (end - start) + "纳秒。");
    }

    /**
     * 自定义环绕通知
     * @param pjp
     * @return 需要返回Object，可以和所有类型的返回值相匹配
     */
    public Object my_around(ProceedingJoinPoint pjp) {
        try {
            // 在proceed之前代码相当于前置通知
            Object proceed = pjp.proceed(); // 相当于method.invoke
            // 在proceed之后代码相当于后置通知
            return proceed;
        } catch (Throwable e) {
            e.printStackTrace();
            // 这里相当于异常通知
        }
        return null;
    }

    /**
     * 自定义返回值后的通知
     * @param jp
     * @param result 被拦截方法的返回值，这个参数的类型要和被拦截方法的返回值类型匹配，否则，返回通知不会触发,Object可以捕获所有
     */
    public void my_after_returning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();

        System.out.println(name + "返回值后的通知，返回值为：" + result);
    }

    /**
     * 切点方法抛出异常后触发的勾子
     * @param jp
     * @param e 方法抛出的异常信息，类型需要和方法抛出的异常相匹配，否则，此勾子不会执行，Exception可以捕获所有异常
     */
    public void my_after_throwing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛出异常： " + e.getMessage());
    }
}
