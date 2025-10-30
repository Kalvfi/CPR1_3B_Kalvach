package org.example.accounts.cron;

import jakarta.inject.Inject;
import org.example.accounts.cron.jobs.InterestJob;
import org.example.accounts.facades.InterestRunnerFacade;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class InterestCronServiceQuartz {
    @Inject
    private InterestRunnerFacade interestRunnerFacade;

    public void start() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(InterestJob.class)
                .withIdentity("interestJob")
                .build();
        job.getJobDataMap().put("facade", interestRunnerFacade);

        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?")) // every minute
                .build();

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}
