package com.hxm.demo.test1.aop.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib子类代理工厂
 * 对UserDao在内存中动态构建一个子类对象
 */

public class ProxyFactory implements MethodInterceptor {
    private Object target;


    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getInstance() {
        Enhancer enhancer = new Enhancer();
        //父类就是目标对象
        enhancer.setSuperclass(target.getClass());
        // MethodInterceptor extends Callback
        enhancer.setCallback(this);

        return enhancer.create();

    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before acitons");

        Object returnValue = method.invoke(target, objects);

        System.out.println("after acitons");
        return returnValue;
    }
}
