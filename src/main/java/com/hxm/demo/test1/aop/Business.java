package com.hxm.demo.test1.aop;

public class Business {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println("My name is "+name);
    }

    public void tel(){
        System.out.println("Telephone from " +name);
    }

    public void doWork(){
        System.out.println(name+" is doing work");
    }
}
