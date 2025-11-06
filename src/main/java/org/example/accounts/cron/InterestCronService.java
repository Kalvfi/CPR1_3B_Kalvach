package org.example.accounts.cron;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.accounts.facades.InterestRunnerFacade;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Singleton
public class InterestCronService {

    @Inject
    private InterestRunnerFacade interestRunnerFacade;

    @Inject
    private ScheduledExecutorService scheduler;

    public void start(){
        scheduler.scheduleAtFixedRate(
                interestRunnerFacade::processAllInterests,
                0,
                10,
                TimeUnit.SECONDS
        );
    }
}
