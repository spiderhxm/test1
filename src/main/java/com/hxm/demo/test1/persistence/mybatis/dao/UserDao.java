package com.hxm.demo.test1.persistence.mybatis.dao;


import com.hxm.demo.test1.persistence.mybatis.object.UserDo;



public interface UserDao {

    public UserDo getByName(String name);
}
