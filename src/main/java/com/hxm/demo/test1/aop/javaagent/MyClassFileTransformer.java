package com.hxm.demo.test1.aop.javaagent;

import javassist.*;

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
        addMethod("com.hxm.demo.test1.aop.javaagent.Business.say");
        addMethod("com.hxm.demo.test1.aop.javaagent.Business.tel");
    }

    private void addMethod(String fullMethodName){
        String className = fullMethodName.substring(0,fullMethodName.lastIndexOf("."));
        String methodName = fullMethodName.substring(fullMethodName.lastIndexOf(".")+1);

        List<String> methodList = methodMap.get(className);
        if (methodList==null){
            methodList = new ArrayList<String>();
            methodMap.put(methodName,methodList);
        }
        methodList.add(methodName);
    }

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className.replace("/",".");
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

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }


        return new byte[0];
    }
}
