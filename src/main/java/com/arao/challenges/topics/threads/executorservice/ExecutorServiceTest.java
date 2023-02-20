package com.arao.challenges.topics.threads.executorservice;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

    public static void main(String[] args) throws Exception {

        // create the executor service
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Runnable
        Runnable runnableTask = () -> {
            try {
                //System.out.println("Runnable task execution");
                TimeUnit.MILLISECONDS.sleep(300);
            } catch(Exception e) {
                e.printStackTrace();
            }
        };

        // Callable
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return " |_ Callable task execution";
        };

        // List of callable tasks
        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);


        // execute() method is void and doesn't give any possibility to get the result of a task's execution or to check the
        // task's status
        System.out.println("- Method execute(Runnable)");
        executorService.execute(runnableTask);

        // submit() submits a Callable or a Runnable task to an ExecutorService and returns a result of type Future
        System.out.println("\n- Method submit(Runnable/Callable):");
        Future<String> future = executorService.submit(callableTask);
        System.out.println(future.get());

        // invokeAny() assigns a collection of tasks to an ExecutorService, causing each to run, and returns the result
        // of a successful execution of one task (if there was a successful execution):
        System.out.println("\n- Method invokeAny(Collection<Callable>):");
        String result = executorService.invokeAny(callableTasks);
        System.out.println(result);

        // invokeAll() assigns a collection of tasks to an ExecutorService, causing each to run, and returns the result of
        // all task executions in the form of a list of objects of type Future:
        System.out.println("\n- Method invokeAll(Collection<Callable>):");
        List<Future<String>> results = executorService.invokeAll(callableTasks);
        results.forEach(f -> {
            try {
                System.out.println(f.get());
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }



}
