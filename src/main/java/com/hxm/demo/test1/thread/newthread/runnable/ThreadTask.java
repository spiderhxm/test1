package com.hxm.demo.test1.thread.newthread.runnable;

import java.sql.Time;

public class ThreadTask implements Runnable{
    //private final static ThreadLocal<String> taskNo = new ThreadLocal<String>();
    private String taskNo;
    private int cnt;


    public ThreadTask(String threadTaskNo,int cnt) {
        this.taskNo = threadTaskNo;
        this.cnt = cnt;
    }


    public void run() {
        for(int i=0;i<this.cnt;i++){
            System.out.println(taskNo+"--"+i);
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
