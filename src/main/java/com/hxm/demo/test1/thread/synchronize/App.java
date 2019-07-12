package com.hxm.demo.test1.thread.synchronize;

public class App{


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new UnsyncTask());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + UnsyncTask.count);
    }


}
