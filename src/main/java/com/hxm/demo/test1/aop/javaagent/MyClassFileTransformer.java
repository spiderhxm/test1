package com.hxm.demo.test1.aop.javaagent;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClassFileTransformer implements ClassFileTransformer {
    final static HashMap<String, List<String>> methodMap = new HashMap<String, List<String>>();

    public MyClassFileTransformer(){
        addMethod("com.hxm.demo.test1.aop.Business.say");
        addMethod("com.hxm.demo.test1.aop.Business.tel");
        System.out.println("intialized methodmap");
    }

    private void addMethod(String fullMethodName){
        String className = fullMethodName.substring(0,fullMethodName.lastIndexOf("."));
        String methodName = fullMethodName.substring(fullMethodName.lastIndexOf(".")+1);

        List<String> methodList = methodMap.get(className);
        if (methodList==null){
            methodList = new ArrayList<String>();
            methodMap.put(className,methodList);
        }
        methodList.add(methodName);
    }

    /**
     * 参数：
     * loader - 定义要转换的类加载器；如果是引导加载器，则为 null
     * className - 完全限定类内部形式的类名称和 The Java Virtual Machine Specification 中定义的接口名称。例如，"java/util/List"。
     * classBeingRedefined - 如果是被重定义或重转换触发，则为重定义或重转换的类；如果是类加载，则为 null
     * protectionDomain - 要定义或重定义的类的保护域
     * classfileBuffer - 类文件格式的输入字节缓冲区（不得修改）
     * 返回：
     * 一个格式良好的类文件缓冲区（转换的结果），如果未执行转换,则返回 null。
     * 抛出：
     * IllegalClassFormatException - 如果输入不表示一个格式良好的类文件
     */
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className=className.replace("/",".");
        if(!methodMap.containsKey(className)){
            return null;
        }
        List<String> methodList = methodMap.get(className);
        if(methodList==null){
            return null;
        }

        //Javaassist技术
        ClassPool pool= ClassPool.getDefault();
        CtClass ctClass = null;
        try {
            ctClass = pool.getCtClass(className);
            for (String method: methodList) {
                CtMethod ctMethod = ctClass.getDeclaredMethod(method);
                if(ctMethod!=null){
                    ctMethod.insertBefore("{System.out.println(\"---before action----\");}");
                }
            }

            return ctClass.toBytecode();

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new byte[0];
    }
}
