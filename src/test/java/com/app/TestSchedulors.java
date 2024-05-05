package com.app;

import com.app.runnables.CleaningScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestSchedulors {
    public static void main(String[] args) {
        ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
//        service.schedule(new CleaningScheduler(), 5, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(new CleaningScheduler(), 5, 4, TimeUnit.SECONDS);

    }
}
