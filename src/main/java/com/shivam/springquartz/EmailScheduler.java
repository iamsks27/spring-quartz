package com.shivam.springquartz;

import com.shivam.springquartz.job.EmailJob;
import lombok.RequiredArgsConstructor;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author sksingh created on 02/01/24
 */
@Component
@RequiredArgsConstructor
public class EmailScheduler implements CommandLineRunner {

    private final Scheduler scheduler;

    @Override
    public void run(String... args) throws Exception {
        String email = "john@gmail.com";

        JobDetail jobDetail = newJob(EmailJob.class)
                .withIdentity("email-job-" + email)
                .usingJobData("email", email)
                .build();


        Trigger trigger = newTrigger()
                .withIdentity("trigger-email-job" + email)
                .startNow()
                .build();


        scheduler.scheduleJob(jobDetail, trigger);
    }
}
