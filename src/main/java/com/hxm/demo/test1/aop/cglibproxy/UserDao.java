package com.hxm.demo.test1.aop.cglibproxy;

//JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用Cglib实现
public class UserDao {

    public void save(){
        System.out.println("saved！！");
    }
}
