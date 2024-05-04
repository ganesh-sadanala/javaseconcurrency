package com.app.runnables;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppThread extends Thread{

    Logger logger= Logger.getLogger(AppThread.class.getName());
    @Override
    public void run(){
        try(BufferedReader reader=new BufferedReader(new FileReader(new File("path_of_file")))){
            String line=null;
            while((line=reader.readLine())!=null){
                line=reader.readLine();
                System.out.println(Thread.currentThread().getName()+"reading the line: "+line);
            }
        }catch (IOException f){
            logger.log(Level.SEVERE, null, f);
        }
    }
}
