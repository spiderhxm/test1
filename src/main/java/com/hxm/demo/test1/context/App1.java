package com.hxm.demo.test1.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {

    public static void  main(String[] args){
        //通过xml配置创建spring容器
        new ClassPathXmlApplicationContext("classpath*:spring/spring-context.xml");

        //获取spring容器中已经初始化的类
        InitBean initBean = (InitBean) ContextUtil.getBean("initBean");

        initBean.doSomething();

    }
}
