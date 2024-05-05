package com.app.runnables;

import java.io.File;

public class CleaningScheduler implements Runnable{
    @Override
    public void run() {
        File folder=new File("filepath");
        File []files=folder.listFiles();
        for(File file:files){
            if(System.currentTimeMillis()-file.lastModified()>5*60*1000){
                System.out.println("This file will be deleted: "+file.getName());
                file.delete();
            }
        }
    }
}
