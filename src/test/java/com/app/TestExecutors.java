package com.app;

import com.app.repo.UserRepository;
import com.app.runnables.UserProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;

public class TestExecutors {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        List<String> users=getUsersFromFile("filename");
        UserRepository userRepository=new UserRepository();
        for(String user:users){
            Future<Integer> future = executorService.submit(new UserProcessor(user, userRepository));
            try {
                System.out.println("Result of the operation is: "+future.get());
            } catch (InterruptedException | ExecutionException e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
        executorService.shutdown();
    }

    public static List<String> getUsersFromFile(String fileName){
        List<String> users=new ArrayList<>();

        try(BufferedReader reader=new BufferedReader(new FileReader(new File(fileName)))){
            String line=null;
            while((line=reader.readLine())!=null){
                users.add(line);
                System.out.println(Thread.currentThread().getName()+"reading the line: "+line);
            }
        }catch (IOException f){
            logger.log(Level.SEVERE, null, f);
        }
        return users;
    }
}
