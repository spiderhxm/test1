package com.hxm.demo.test1.unittest.junit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/spring-unittest.xml");

        FunctionCal functionCal = (FunctionCal) applicationContext.getBean("functionCal");

        int c = functionCal.cal("add", 1, 2);

        System.out.println("result is " +c);
    }
}
