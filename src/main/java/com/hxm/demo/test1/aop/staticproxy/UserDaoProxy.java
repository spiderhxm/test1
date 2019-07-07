package com.hxm.demo.test1.aop.staticproxy;

public class UserDaoProxy implements UserDao {
    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("--before--");
        userDao.save();
        System.out.println("--after--");
    }
}
