package com.hxm.demo.test1.aop;

public class AppAgent {
    public static void main(String[] args){
        Business business = new Business();
        business.setName("Shawn");
        business.say();
        business.doWork();
        business.tel();
    }
}
