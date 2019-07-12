package com.hxm.demo.test1.aop.javaagent;

import java.lang.instrument.Instrumentation;


//将本目录的内容打包Jar。具体参考：https://www.cnblogs.com/prettrywork/p/10950055.html
//https://www.jianshu.com/p/3866f075524f
//https://www.cnblogs.com/stateis0/p/9062199.html
public class MyAgent {

    //jvm 使用参数 -javaagent:/jar包路径=[agentArgs 参数]
    public static void premain(String agentArgs, Instrumentation instrumentation){
        System.out.println("start to add transformer; agentArgs="+agentArgs);
        instrumentation.addTransformer(new MyClassFileTransformer());

    }
}
