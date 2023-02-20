package com.arao.challenges.topics.threads.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorServiceTest {

    public static void main(String[] args) {

        // Create scheduled executor service
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // Runnable task
        Runnable runnableTask = () -> {
            try {
                System.out.println(" |_ Runnable task execution");
                TimeUnit.MILLISECONDS.sleep(300);
            } catch(Exception e) {
                e.printStackTrace();
            }
        };

        // Callable task
        Callable<Object> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(2000);
            return " |_ Callable task executed";
        };

        // schedule tasks
        // To schedule a single task's execution after a fixed delay, use the scheduled() method of the ScheduledExecutorService.
        System.out.println("- Method schedule(Runnable/Callable): ");
        scheduler.schedule(callableTask, 1, TimeUnit.SECONDS);

        // The scheduleAtFixedRate() method lets us run a task periodically after a fixed delay. The code above delays for one
        // second before executing callableTask.
        // The following block of code will run a task after an initial delay of 1 second. And after that, it will run the
        // same task every 3 seconds:
        System.out.println("\n- Method scheduleAtFixedRate(Runnable, waitTime, executeTime, timeUnit): ");
        scheduler.scheduleAtFixedRate(runnableTask, 1, 2, TimeUnit.SECONDS);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch(Exception e) {e.printStackTrace();}

        scheduler.shutdown();
    }
}
