package com.hxm.demo.test1.aop.jdkdynamicproxy;

import com.hxm.demo.test1.aop.staticproxy.UserDao;
import com.hxm.demo.test1.aop.staticproxy.UserDaoImp;

public class App {
    public static void  main(String[] args){
        UserDao userDao = new UserDaoImp();

        System.out.println(userDao.getClass());

        UserDao proxyInstance = (UserDao) new ProxyFactory(userDao).getInstance();

        proxyInstance.save();

        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxyInstance.getClass());
    }
}
