package com.hxm.demo.test1.thread.newthread.callable;

import java.util.concurrent.Callable;
//实现 Callable 接口。 相较于实现 Runnable 接口的方式，方法可以有返回值，并且可以抛出异常
public class ThreadTask implements Callable {
    public Object call() throws Exception {
        Long threadId = Thread.currentThread().getId();

        for (int i = 0; i < 10; i++) {
            System.out.println("ID:" + threadId + "--" + i);
            Thread.sleep((int)(Math.random()*1000));
        }

        return 0;
    }
}
