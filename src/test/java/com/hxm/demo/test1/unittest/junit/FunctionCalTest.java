package com.hxm.demo.test1.unittest.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FunctionCalTest {

    @InjectMocks
    private FunctionCal functionCal = new FunctionCal();

    @Mock
    private FunctionA functionA;

    @Test
    public void testCal() {
        Mockito.when(functionA.add(1, 2)).thenReturn(4);
        Mockito.doReturn(5).when(functionA).add(2, 2);

        System.out.println("1, 2 :" + functionCal.cal("add", 1, 2));
        System.out.println("2, 2 :" + functionCal.cal("add", 2, 2));
        System.out.println("2, 3 :" + functionCal.cal("add", 2, 2));

        assert functionCal.cal("add",1,2)==4;
        //Assert.assertEquals(4,functionCal.cal("add",1,2));

    }
}
