package com.hxm.demo.test1.classload;

import com.hxm.demo.test1.aop.Business;
import com.hxm.demo.test1.unittest.junit.FunctionCal;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class App {

    public static void main(String[] args) throws UnsupportedEncodingException, InvocationTargetException, IllegalAccessException, InstantiationException {
        try {
            System.out.println("classloader=="+ Class.forName("com.hxm.demo.test1.classload.App").getClassLoader());

            System.out.println("System/app classloader=="+ ClassLoader.getSystemClassLoader());

            System.out.println("parent classloader=="+ ClassLoader.getSystemClassLoader().getParent());
            //ext classloader的父类为空
            //由外部类创建ClassLoader时直接指定一个ClassLoader为parent
            //创建extClassloader时传入的parent为null
            System.out.println("parent2 classloader=="+ ClassLoader.getSystemClassLoader().getParent().getParent());

            //自定义的classloader的parent为AppClassloader


            System.out.println(App.class.getName());
            Class clazz = App.class;
            //clazz.getClassLoader().getParent()
            //clazz的classloader在其classpath下找出指定路径（相对于classpath的相对路径）的资源
            String path =clazz.getResource("/"+clazz.getName().replace(".","/")+".class").getPath();
            System.out.println(path);
            System.out.println(new File(path).getParent());
            System.out.println(URLDecoder.decode(new File(path).getParent(),"utf-8"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //BootstrapClassLoader、ExtClassLoader、AppClassLoader实际是查阅相应的环境属性sun.boot.class.path、java.ext.dirs和java.class.path来加载资源文件的

        //BootstrapClassLoader加载的jar包路径
        System.out.println("bootstrap classloader classpath: "+System.getProperty("sun.boot.class.path"));

        //ExtClassLoader的加载路径
        System.out.println("ext classloader classpath: "+System.getProperty("java.ext.dirs"));

        //Appclass Loader也称为SystemAppClass
        System.out.println("app classloader classpath: "+System.getProperty("java.class.path"));

        try {
            Method method = FunctionCal.class.getDeclaredMethod("cal1", String.class, int.class, int.class);
            String res = method.invoke(FunctionCal.class.newInstance(),"add",2,3).toString();
            System.out.println("res="+res);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
