package com.arao.challenges.topics.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Scanner;

public class QuartzMain {

    public static void main(String[] args) {
        try {
            // show menu options for Quartz tasks
            Scanner scanner = new Scanner(System.in);
            System.out.print("Quartz Menu Options: " +
                    "\n 1. Exercise 1 - First Quartz Program" +
                    "\n 2. Exercise 2 - Cron-Based Triggers" +
                    "\n 3. Exercise 3 - Job Parameter and Job State" +
                    "\n 4. Exercise 4 - Job Misfires" +
                    "\nEnter the option: ");
            int option = scanner.nextInt();

            switch(option) {
                case 1: ex1FirstQuartzProgram(); break;
                    /* This example is designed to demonstrate how to get up and running with Quartz.
                       This example will fire off a simple job that says “Job 1 is saying Hello started at <DATE>”
                       The program will perform the following actions:
                         1. Start up the Quartz Scheduler
                         2. Schedule a job to every 5 seconds
                         3. Wait for 20 seconds to give Quartz a chance to run the job
                         4. Shut down the Scheduler
                    */
                case 2: ex2CronBasedTriggers();  break;
                    /* This example is designed to demonstrate how you can use Cron Triggers to schedule jobs.
                       This example will fire off several simple jobs that say “Hello World” and display the date and time that
                        the job was executed.
                       The program will perform the following actions:
                         1. Start up the Quartz Scheduler
                         2. Schedule several jobs using various features of CronTrigger
                         3. Wait for 300 seconds (5 minutes) to give Quartz a chance to run the jobs
                         4. Shut down the Scheduler
                     */
                case 3: ex3JobParamAndJobState(); break;
                     /* This example is designed to demonstrate how you can pass run-time parameters into quartz jobs and
                        how you can maintain state in a job.
                        The program will perform the following actions:
                          1. Start up the Quartz Scheduler
                          2. Schedule two jobs, each job will execute the every ten seconds for a total of times
                          3. The scheduler will pass a run-time job parameter of “Green” to the first job instance
                          4. The scheduler will pass a run-time job parameter of “Red” to the second job instance
                          5. The program will wait 60 seconds so that the two jobs have plenty of time to run
                          6. Shut down the Scheduler
                     */
                case 4: ex4JobMisfire(); break;
                     /* This example is designed to demonstrate concepts related to trigger misfires.
                        The program will perform the following actions:
                          1. Start up the Quartz Scheduler
                          2. Schedule two jobs, each job will execute the every three seconds, indefinitely
                          3. The jobs will take ten seconds to run (preventing the execution trigger from firing every three seconds)
                          4. Each job has different misfire instructions
                          5. The program will wait 10 minutes so that the two jobs have plenty of time to run
                          6. Shut down the Scheduler
                     */                
                default:
                    System.out.println("Invalid option"); break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * This example is designed to demonstrate concepts related to trigger misfires.
     */
    private static void ex4JobMisfire() {
        try {
            // 1. Start up the Quartz Scheduler
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();

            // 2. Schedule two jobs, each job will execute the every three seconds, indefinitely

            // Job #1 uses the default “smart” misfire policy for simple triggers, which causes the trigger to fire at
            // it’s next normal execution time.
            JobDetail job = JobBuilder.newJob(StatefulDumbJob.class)
                                .withIdentity("Ex4Job1", "group1")
                                .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 10000L)
                                .build();

            SimpleTrigger trigger = TriggerBuilder.newTrigger()
                                        .withIdentity("Ex4Trigger1", "group1")
                                        .startNow()
                                        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                                        .withIntervalInSeconds(3)
                                                        .repeatForever())
                                        .build();

            scheduler.scheduleJob(job, trigger);

            // job #2 - Note: The trigger for job #2 is set with a misfire instruction that will cause it to reschedule
            // with the existing repeat count. This policy forces quartz to refire the trigger as soon as possible.
            job = JobBuilder.newJob(StatefulDumbJob.class)
                    .withIdentity("Ex4Job2", "group1")
                    .usingJobData(StatefulDumbJob.EXECUTION_DELAY, 5000L)
                    .build();

            trigger = TriggerBuilder.newTrigger()
                        .withIdentity("Ex4Trigger2", "group1")
                        .startNow()
                        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                        .withIntervalInSeconds(3)
                                        .repeatForever()
                                        .withMisfireHandlingInstructionNowWithExistingCount()) // 4. Each job has different misfire instructions
                        .build();

            scheduler.scheduleJob(job, trigger);

            // 3. The jobs will take ten seconds to run (preventing the execution trigger from firing every three seconds)
            // The scheduler is then started.
            scheduler.start();

            // 5. The program will wait 10 minutes so that the two jobs have plenty of time to run
            Thread.sleep(60L * 1000L); // 10 minutes

            // 6. Shut down the Scheduler, we will gracefully shutdown the scheduler:
            scheduler.shutdown(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This example is designed to demonstrate how you can pass run-time parameters into quartz jobs and how you can
     * maintain state in a job.
     */
    private static void ex3JobParamAndJobState() {
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();

            // Job #1 executed every 10 seconds for a total of 5 times
            JobDetail job = JobBuilder.newJob(ColorJob.class)
                                .withIdentity("ex3Job1", "group1")
                                .usingJobData(ColorJob.JOB_KEY, "E3JOB1")
                                .usingJobData(ColorJob.FAVORITE_COLOR, "Green")
                                .usingJobData(ColorJob.EXECUTION_COUNT, 1)
                                .build();

            SimpleTrigger trigger = TriggerBuilder.newTrigger()
                                        .withIdentity("ex3Trigger1", "group1")
                                        .startNow()
                                        .withSchedule(SimpleScheduleBuilder
                                                        .simpleSchedule()
                                                        .withIntervalInSeconds(10)
                                                        .withRepeatCount(4))
                                        .build();

            scheduler.scheduleJob(job, trigger);

            // Job #2 executed every 10 seconds
            job = JobBuilder.newJob(ColorJob.class)
                    .withIdentity("ex3Job2", "group1")
                    .usingJobData(ColorJob.JOB_KEY, "E3JOB2")
                    .usingJobData(ColorJob.FAVORITE_COLOR, "Red")
                    .usingJobData(ColorJob.EXECUTION_COUNT, 1)
                    .build();

            trigger = TriggerBuilder.newTrigger()
                        .withIdentity("ex3Trigger2", "group1")
                        .startNow()
                        .withSchedule(SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(10)
                                .withRepeatCount(4))
                        .build();

            scheduler.scheduleJob(job, trigger);

            // Starting scheduler
            scheduler.start();

            // To let the program have an opportunity to run the job, we then sleep for one minute (60 seconds)
            Thread.sleep(60L * 1000L);

            // Finally, we will gracefully shutdown the scheduler:
            // Note: passing true into the shutdown message tells the Quartz Scheduler to wait until all jobs have completed
            // running before returning from the method call.
            scheduler.shutdown(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This example is designed to demonstrate how you can use Cron Triggers to schedule jobs.
     */
    private static void ex2CronBasedTriggers() {
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();

            // Job #1 is scheduled to run every 20 seconds
            JobDetail job = JobBuilder.newJob(SimpleJob.class)
                            .withIdentity("ex2Job1", "group1")
                            .usingJobData("jobDescription", "Job 1 - Run every 20 seconds")
                            .build();

            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                                        .withIdentity("ex2Trigger1", "group1")
                                        .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
                                        .build();

            scheduler.scheduleJob(job, cronTrigger);

            // Job #2 is scheduled to run every other minute, starting at 15 seconds past the minute.
            job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("exJob2", "group1")
                    .usingJobData("jobDescription", "Job 2 - Run every other minute, starting at 15 seconds past the minute")
                    .build();

            cronTrigger = TriggerBuilder.newTrigger()
                            .withIdentity("ex2Trigger2", "group1")
                            .withSchedule(CronScheduleBuilder.cronSchedule("15 0/2 * * * ?"))
                            .build();

            scheduler.scheduleJob(job, cronTrigger);

            // Job #3 is scheduled to run every other minute, between 8am and 5pm (17 o’clock).
            job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("exJob3", "group1")
                    .usingJobData("jobDescription", "Job 3 - Run every other minute, between 8am and 5pm (17 o’clock)")
                    .build();

            cronTrigger = TriggerBuilder.newTrigger()
                            .withIdentity("ex2Trigger3", "group1")
                            .withSchedule(CronScheduleBuilder.cronSchedule("0 0/2 8-17 * * ?"))
                            .build();

            scheduler.scheduleJob(job, cronTrigger);

            // Job #4 is scheduled to run every three minutes but only between 5pm and 11pm
            job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("exJob4", "group1")
                    .usingJobData("jobDescription", "Job 4 - Run every three minutes but only between 5pm and 11pm")
                    .build();

            cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("ex2Trigger4", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/3 17-23 * * ?"))
                    .build();

            scheduler.scheduleJob(job, cronTrigger);

            // Job #5 is scheduled to run at 10am on the 1st and 15th days of the month
            job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("ex2Job5", "group1")
                    .usingJobData("jobDescription", "Job 5 - Run at 10am on the 1st and 15th days of the month")
                    .build();

            cronTrigger = TriggerBuilder.newTrigger()
                            .withIdentity("ex2Trigger5", "group1")
                            .withSchedule(CronScheduleBuilder.cronSchedule("0 0 10am 1,15 * ?"))
                            .build();

            scheduler.scheduleJob(job, cronTrigger);

            // Job #6 is scheduled to run every 30 seconds on Weekdays (Monday through Friday)
            job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("exJob6", "group1")
                    .usingJobData("jobDescription", "Job 6 - Run every 30 seconds on Weekdays (Monday through Friday)")
                    .build();

            cronTrigger = TriggerBuilder.newTrigger()
                            .withIdentity("exTrigger6", "group1")
                            .withSchedule(CronScheduleBuilder.cronSchedule("0,30 * * ? * MON-FRI"))
                            .build();

            scheduler.scheduleJob(job, cronTrigger);

            // Job #7 is scheduled to run every 30 seconds on Weekends (Saturday and Sunday)
            job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("ex2Job7", "group1")
                    .usingJobData("jobDescription", "Job 7 - Run every 30 seconds on Weekends (Saturday and Sunday)")
                    .build();

            cronTrigger = TriggerBuilder.newTrigger()
                            .withIdentity("ex2Trigger7", "group1")
                            .withSchedule(CronScheduleBuilder.cronSchedule("0,30 * * ? * SAT,SUN"))
                            .build();

            scheduler.scheduleJob(job, cronTrigger);

            // Job #8 is scheduled to run every 10 seconds on May 29th
            job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("ex2Job8", "group1")
                    .usingJobData("jobDescription", "Job 8 - Run every 2 seconds on May 29th")
                    .build();

            cronTrigger = TriggerBuilder.newTrigger()
                            .withIdentity("ex2Trigger8", "group1")
                            .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * 29 5 ?"))
                            .build();

            scheduler.scheduleJob(job, cronTrigger);

            // Start scheduler
            scheduler.start();

            // To let the program have an opportunity to run the job, we then sleep for five minutes (300 seconds).
            // The scheduler is running in the background and should fire off several jobs during that time.

            // Note: Because many of the jobs have hourly and daily restrictions on them, not all of the jobs will run in this example.
            // For example: Job #6 only runs on Weekdays while Job #7 only runs on Weekends.
            Thread.sleep(120L * 1000L);

            // Finally, we will gracefully shut down the scheduler:
            scheduler.shutdown(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * First Quartz program setting the trigger to run every 5 seconds until the scheduler is shut down
     */
    private static void ex1FirstQuartzProgram() {
        try {
            // Creation of scheduler by Standard scheduler factory
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();

            // Create Job data map to set job information for job execution
            JobDataMap jobDM = new JobDataMap();
            jobDM.put("jobDescription", "Job 1 - Run every 5 seconds");

            // Define the job and tie it to SimpleJob class
            JobDetail job  = JobBuilder.newJob(SimpleJob.class)
                            .withIdentity("ex1Job1", "group1")
                            .setJobData(jobDM)
                            .build();

            // Trigger the job to run now and every 10 seconds forever
            Trigger trigger = TriggerBuilder.newTrigger()
                                .withIdentity("ex1Trigger1", "group1")
                                .startNow()
                                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                                .withIntervalInSeconds(5)
                                                .repeatForever())
                                .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

            // Tell the scheduler start up
            scheduler.start();

            // Sleep for 20 seconds, during this time, the scheduler is running in the background, then after this time
            // shut down the scheduler to finish job execution
            Thread.sleep(20L * 1000L);
            scheduler.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
