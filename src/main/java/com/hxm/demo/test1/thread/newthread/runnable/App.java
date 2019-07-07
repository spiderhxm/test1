package com.hxm.demo.test1.thread.newthread.runnable;

public class App {
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            ThreadTask threadTask = new ThreadTask(String.valueOf(i),10);
            new Thread(threadTask).start();
        }

        System.out.println("Done!" + (int)0.9);
    }
}
