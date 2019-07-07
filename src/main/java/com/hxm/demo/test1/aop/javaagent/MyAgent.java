package com.hxm.demo.test1.aop.javaagent;

import java.lang.instrument.Instrumentation;

public class MyAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation){
        instrumentation.addTransformer();

    }
}
