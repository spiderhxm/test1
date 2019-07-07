package com.hxm.demo.test1.persistence.mybatis;

import com.hxm.demo.test1.persistence.mybatis.dao.UserDao;
import com.hxm.demo.test1.persistence.mybatis.object.UserDo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


public class App {

    public static void main(String[] args){
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"));
            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserDao userDao = sqlSession.getMapper(UserDao.class);
            String name = "猪八戒";
            UserDo userDo = userDao.getByName(name);

            System.out.println("address is " + userDo.getAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
