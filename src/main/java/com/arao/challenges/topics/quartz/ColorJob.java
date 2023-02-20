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
public class ColorJob implements Job {

    public static final String JOB_KEY = "jobKey";
    public static final String FAVORITE_COLOR = "favoriteColor";
    public static final String EXECUTION_COUNT = "executionCount";

    private int counter = 1;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // Retrieve job data map
        JobDataMap jobData = jobExecutionContext.getJobDetail().getJobDataMap();
        String jobKey = jobData.getString(JOB_KEY);
        String favoriteColor = jobData.getString(FAVORITE_COLOR);
        int count = jobData.getInt(EXECUTION_COUNT);

        // The count variable is incremented and stored back into the job data map so that job state can be preserved
        count++;
        jobData.put(EXECUTION_COUNT, count);

        System.out.println("ColorJob: " + jobKey + " executing at " + new Date() + "\n" +
                "  favorite color is " + favoriteColor + "\n" +
                "  execution count (from job map) is " + count + "\n" +
                "  execution count (from job member variable) is " + counter + "\n");

    }
}
