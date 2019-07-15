package com.hxm.demo.test1.persistence.mybatis.Service;

import com.hxm.demo.test1.persistence.mybatis.dao.UserDao;
import com.hxm.demo.test1.persistence.mybatis.object.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class UserService {
    @Autowired
    private UserDao userDao;


    public void printUserAddr(String name) {

        UserDo userDo = userDao.getByName(name);
        System.out.println("the address is " + userDo.getAddress());
    }

    public void printAddrByGender(String gender) {

        List<UserDo> userDoList = userDao.getByGender(gender);
        for (UserDo userDo : userDoList) {
            System.out.println("name: " + userDo.getName() + " address: " + userDo.getAddress());
        }
    }

    public void updateAddr(String name, String addr) {
        UserDo userDo = new UserDo();
        userDo.setName(name);
        userDo.setAddress(addr);
        userDao.updateAddr(userDo);
    }

    //异常分为检查异常，和非检查异常（也就是运行时异常）。/
    //检查异常例如IOException异常等，在你写代码时编译提示你必须try catch 或向上抛，反正就是必须处理。/
    //而运行时异常，就是在运行时的产生异常（有点废话啊，不过就是这个意思），例如/by zero异常
    //使用@Transaction 时默认为RuntimeException（也就是运行时异常）异常才会回滚
    //解决方法。这样添加事务@Transactional(rollbackFor = Exception.class) 不管检查异常还是非检查异常都会回滚
    @Transactional(rollbackFor = Exception.class)
    public void testTranMgnt(String addr) throws Exception {
        UserDo userDo = new UserDo();
        userDo.setName("shawn");
        userDo.setAddress(addr);
        userDao.updateAddr(userDo);

        throw new Exception("---检查异常-----");
        //throw new RuntimeException("---运行时异常-----");

        //int i = 1/0;


    }
}
