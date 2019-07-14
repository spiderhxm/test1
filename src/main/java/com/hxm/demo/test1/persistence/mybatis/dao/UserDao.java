package com.hxm.demo.test1.persistence.mybatis.dao;


import com.hxm.demo.test1.persistence.mybatis.object.UserDo;

import java.util.List;


public interface UserDao {

    public UserDo getByName(String name);

    List<UserDo> getByGender(String gender);


    //接口中方法的修饰符：public abstract（默认不写）
    boolean updateAddr(UserDo userDo);
}
