package com.hxm.demo.test1.aop.staticproxy;

public class App {
    public static void  main(String[] args){
        UserDao userDao = new UserDaoImp();

        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);

        userDaoProxy.save();
    }
}
