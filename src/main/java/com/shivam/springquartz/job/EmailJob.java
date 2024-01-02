package com.shivam.springquartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

/**
 * @author sksingh created on 02/01/24
 */
@Slf4j
@Component
public class EmailJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {

        // String email = jobExecutionContext.getJobDetail().getJobDataMap().getString("email");

        String email = jobExecutionContext.getMergedJobDataMap().getString("email");
        log.info("Sending mail to email: {}", email);
    }
}
