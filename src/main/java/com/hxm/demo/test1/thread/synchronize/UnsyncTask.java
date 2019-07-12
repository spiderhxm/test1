package com.hxm.demo.test1.thread.synchronize;

public class UnsyncTask implements Runnable {
    public static int count = 0;
    public void run() {
        for (int i = 0; i < 1000000; i++)
            count++;
    }
}
