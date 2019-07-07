package com.hxm.demo.test1.persistence.mybatis.Service;

import com.hxm.demo.test1.persistence.mybatis.dao.UserDao;
import com.hxm.demo.test1.persistence.mybatis.object.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserService {
    @Autowired
    private UserDao userDao;


    public void printUserAddr(String name){

        UserDo userDo = userDao.getByName(name);
        System.out.println("the address is " + userDo.getAddress());
    }
}
