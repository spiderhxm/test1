package com.hxm.demo.test1.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
@Slf4j
public class App
{
    private static final Logger logger           = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        logger.info("hello");
        log.info("hello");

        String[] sa = {"a","bs"};
        
        List<String> sl = Arrays.asList(sa);
        
        for(String s:sl) {
        	System.out.println("string:"+s);
        }
        
        List<String> sl1 = Arrays.asList("d","g");
        for(String s:sl1) {
        	System.out.println("string:"+s);
        }

        Boolean b1 = Boolean.valueOf(true);

        Enum1 e1 = Enum1.TUE;

        System.out.println(e1.name()+e1.getV1()+e1.getV2());
    }
}
