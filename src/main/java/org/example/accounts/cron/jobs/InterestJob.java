package org.example.accounts.cron.jobs;

import org.example.accounts.facades.InterestRunnerFacade;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class InterestJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        InterestRunnerFacade facade = (InterestRunnerFacade) context.getMergedJobDataMap().get("facade");
        facade.processAllInterests();
    }
}
