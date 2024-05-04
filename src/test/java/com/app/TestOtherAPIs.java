package com.app;

import com.app.runnables.LoggingProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;

import static java.util.concurrent.ForkJoinTask.invokeAll;

public class TestOtherAPIs {
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> callables=new ArrayList<>();
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        callables.add(new LoggingProcessor());
        List<Future<Boolean>> futures = null;
        try {
            futures = service.invokeAll(callables);
            for(Future<Boolean> future:futures){
                try {
                    System.out.println("operation result: "+future.get());
                } catch (InterruptedException | ExecutionException e) {
                    logger.log(Level.SEVERE, null, e);
                }
            }
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, null, e);
        }
        service.shutdown();
        try {
            System.out.println(service.awaitTermination(30, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            service.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
