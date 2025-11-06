package org.example.entries.cron;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.entries.facades.AccountTransferEntryExportFacade;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Singleton
public class AccountTransferEntryCronService {
    @Inject
    private AccountTransferEntryExportFacade accountTransferEntryExportFacade;

    @Inject
    private ScheduledExecutorService scheduler;

    public void start(){
        scheduler.scheduleAtFixedRate(
                accountTransferEntryExportFacade::writeAllEntries,
                0,
                5,
                TimeUnit.MINUTES
        );
    }
}
