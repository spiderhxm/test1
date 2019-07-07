package com.hxm.demo.test1.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ContextUtil implements ApplicationContextAware {
    private  static ApplicationContext applicationContext;

    //Spring容器创建本bean后将自身通过这个方法传入
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextUtil.applicationContext = applicationContext;
    }

    public static Object getBean(String name) throws BeansException{
        return applicationContext.getBean(name);
    }
}
