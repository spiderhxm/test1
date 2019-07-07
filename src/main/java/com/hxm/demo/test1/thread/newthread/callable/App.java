package com.hxm.demo.test1.thread.newthread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class App {
    public static  void main(String[] args){
        ThreadTask threadTask = new ThreadTask();
        //执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果
        FutureTask<Integer> futureTask = new FutureTask(threadTask);

        new Thread(futureTask).start();

        try {
            //FutureTask是Future接口的一个唯一实现类
            // .get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回
            System.out.println("return="+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
