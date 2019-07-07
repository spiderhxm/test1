package com.hxm.demo.test1.aop.aspectj.xml;


import org.aspectj.lang.ProceedingJoinPoint;


public class MyAspect {
    //环绕通知
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("before aspectj actions");

        Object returnValue = proceedingJoinPoint.proceed();

        System.out.println("after aspectj actions");

        return returnValue;


    }
}
