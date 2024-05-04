package com.app;

import java.io.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRunnable {
    Logger logger= Logger.getLogger(TestRunnable.class.getName());

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try(BufferedReader reader=new BufferedReader(new FileReader(new File("path_of_file")))){
                String line=null;
                while((line=reader.readLine())!=null){
                    line=reader.readLine();
                    System.out.println(Thread.currentThread().getName()+"reading the line: "+line);
                }
            }catch (IOException f){
                logger.log(Level.SEVERE, null, f);
            }
        };
        Thread thread=new Thread(runnable);

        // Executor API
        // executes submitted tasks
        Executor executor= Executors.newSingleThreadExecutor();
        executor.execute(runnable);

        // ExecutorService
        // Manages lifecycle of all individual threads and also Executor
        // Provides submit method, which accepts both Runnable and Callable objects
        // Helps execute a collection of Callable/Runnable objects
        // Helps to capture the output of a task
        // Helps to shutdown Executor

    }
}
