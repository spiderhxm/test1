package com.hxm.demo.test1.aop.cglibproxy;

public class App {

    public static  void main(String[] args){
        UserDao userDao = new UserDao();
        System.out.println(userDao.getClass());

        ProxyFactory proxyFactory = new ProxyFactory(userDao);

        UserDao instance = (UserDao) proxyFactory.getInstance();

        instance.save();

        System.out.println(instance.getClass());

//        在Spring的AOP编程中:
//        如果加入容器的目标对象有实现接口,用JDK代理
//        如果目标对象没有实现接口,用Cglib代理

    }
}
