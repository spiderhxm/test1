package com.hxm.demo.test1.context.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class App {
    @Value("${p.p2}")  //要让注解生效，必须要在xml中配置<context:component-scan
    private String p2;



    public String getP2(){
        return this.p2;
    };


    public static void main(String[] args){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");


        //只有spring注入的bean会对@注解做解析
       App app1 = (App) applicationContext.getBean("app");

       App app2 = new App();

        System.out.println("p2 in app1 ="+app1.getP2());

       System.out.println("p2 in app2 ="+app2.getP2());
    }
}
