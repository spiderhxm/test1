package com.hxm.demo.test1.context;

import org.springframework.beans.factory.InitializingBean;

//InitializingBean接口为bean提供了初始化方法的方式
public class InitBean implements InitializingBean {

    private String p2;

    public void setP2(String p2){
        this.p2 =p2;
    }

    //spring初始化bean的时候，如果bean实现了InitializingBean接口，会自动调用afterPropertiesSet方法
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName()+ "has been initialized");
        System.out.println("p2 in "+ "has been initialized ="+ p2);
    }

    public void doSomething(){
        System.out.println("hello world");
    }
}
