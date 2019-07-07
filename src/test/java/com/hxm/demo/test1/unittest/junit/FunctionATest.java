package com.hxm.demo.test1.unittest.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FunctionATest {
    private FunctionA functionA;

    @Before
    public void  setUp(){
        this.functionA = new FunctionAImpl();
    }

    @Test
    public void  TestAdd(){
        int c = functionA.add(1,2);
        System.out.println("resutl is " + functionA.add(1,2));
        Assert.assertEquals(3,c);

    }
}
