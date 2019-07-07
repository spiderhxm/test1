package com.hxm.demo.test1.aop.aspectj.xml;

import com.hxm.demo.test1.aop.cglibproxy.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/spring-aspectj.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        userDao.save();
    }
}
