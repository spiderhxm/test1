package com.hxm.demo.test1.persistence.mybatis;

import com.hxm.demo.test1.persistence.mybatis.Service.UserService;
import com.hxm.demo.test1.persistence.mybatis.dao.UserDao;
import com.hxm.demo.test1.persistence.mybatis.object.UserDo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class AppSpring {



    
    public static void main(String[] args){

            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");

            UserService userService = (UserService) applicationContext.getBean("userService");
            userService.updateAddr("jack","香港1");
            userService.printUserAddr("jack");
            userService.printAddrByGender("male");



            userService.testTranMgnt("sichuan77");


    }
}
