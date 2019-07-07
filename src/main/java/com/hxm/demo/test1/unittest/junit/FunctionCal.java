package com.hxm.demo.test1.unittest.junit;

import org.springframework.beans.factory.annotation.Autowired;

public class FunctionCal {

    @Autowired
    private FunctionA functionA;

    public int cal(String oper, int a, int b){
        int result;
        if(oper.equals("add")){
            result = functionA.add(a,b);
        }else{
            result = 0;
        }

        return result;
    }
}
