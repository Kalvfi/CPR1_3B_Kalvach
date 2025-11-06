package org.example.accounts.facades;


import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.accounts.SaveAccount;
import org.example.accounts.services.AccountStorageService;
import org.example.accounts.services.AccountTransferService;

import java.util.Calendar;

@Singleton
public class InterestRunnerFacade {

    @Inject
    private AccountStorageService accountStorageService;

    @Inject
    AccountTransferService accountTransferService;

    public void processAllInterests()
    {
        accountStorageService.getAllBankAccounts().forEach(account -> {
            if (account instanceof SaveAccount saveAccount && saveAccount.getInterestDate().getTimeInMillis() <= System.currentTimeMillis()){
                accountTransferService.interest(saveAccount);
                saveAccount.getInterestDate().add(Calendar.SECOND, 50);
            }
        });
    }
}
