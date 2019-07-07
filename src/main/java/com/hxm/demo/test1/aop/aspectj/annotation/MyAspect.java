package com.hxm.demo.test1.aop.aspectj.annotation;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    //方法必须private，没有返回值，没有参数
    @Pointcut("execution(* com.hxm.demo.test1.aop.cglibproxy.*.*(..))")
    private void pointCut(){}

    //环绕通知
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("before aspectj anno actions");

        Object returnValue = proceedingJoinPoint.proceed();

        //获取带参方法的参数
        System.out.println(proceedingJoinPoint.getArgs());

        //获取他们的目标对象信息
        System.out.println(proceedingJoinPoint.getTarget());

        //获取被增强的方法相关信息
        System.out.println(proceedingJoinPoint.getSignature().toString());

        System.out.println("after aspectj anno actions");

        return returnValue;


    }
}
