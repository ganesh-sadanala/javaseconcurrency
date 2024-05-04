package com.app;

import com.app.runnables.AppThread;

public class TestThreads {
    public static void main(String[] args) throws InterruptedException {
        AppThread thread1=new AppThread();
        AppThread thread2=new AppThread();
        AppThread thread3=new AppThread();

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
