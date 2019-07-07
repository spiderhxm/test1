package com.hxm.demo.test1.aop.staticproxy;

public class UserDaoImp implements UserDao {
    public void save() {
        System.out.println("I saved!");
    }
}
