package com.arao.challenges.topics.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

import java.util.Date;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class StatefulDumbJob implements Job {

    public static final String NUM_EXECUTIONS = "numberExecutions";
    public static final String EXECUTION_DELAY = "executionDelay";

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            System.out.println("--- " + jobExecutionContext.getJobDetail().getKey() + " executing [" + new Date() + "]");

            // Get job data
            JobDataMap jobData = jobExecutionContext.getJobDetail().getJobDataMap();

            // get execute count from job if exists
            int executeCount = jobData.containsKey(NUM_EXECUTIONS) ? jobData.getInt(NUM_EXECUTIONS) : 0;

            // Increase execution count and set into job data number of executions
            executeCount++;
            jobData.put(NUM_EXECUTIONS, executeCount);

            // get delay parameter in case job contains it, otherwise, set 10 seconds delay
            Long delay = jobData.containsKey(EXECUTION_DELAY) ? jobData.getLong(EXECUTION_DELAY) : 10000L;

            try {
                Thread.sleep(delay);
            } catch (Exception ignore) {
            }

            System.out.println("  - " + jobExecutionContext.getJobDetail().getKey() + " complete (" + executeCount + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
