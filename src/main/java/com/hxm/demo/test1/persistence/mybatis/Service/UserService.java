package com.hxm.demo.test1.persistence.mybatis.Service;

import com.hxm.demo.test1.persistence.mybatis.dao.UserDao;
import com.hxm.demo.test1.persistence.mybatis.object.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserService {
    @Autowired
    private UserDao userDao;


    public void printUserAddr(String name){

        UserDo userDo = userDao.getByName(name);
        System.out.println("the address is " + userDo.getAddress());
    }

    public void printAddrByGender(String gender){

       List<UserDo> userDoList = userDao.getByGender(gender);
       for(UserDo userDo : userDoList) {
           System.out.println("name: "+userDo.getName()+" address: " + userDo.getAddress());
       }
    }

    public void updateAddr(String name, String addr){
        UserDo userDo = new UserDo();
        userDo.setName(name);
        userDo.setAddress(addr);
        userDao.updateAddr(userDo);
    }
}
