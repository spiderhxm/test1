package com.hxm.demo.test1.aop.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */

public class ProxyFactory {

    private Object target;


    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before actions");
                        Object returnValue = method.invoke(target,args);
                        System.out.println("after actions");
                        return returnValue;
                    }
                });

    }
}
