package org.example.accounts.facades;


import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.accounts.SaveAccount;
import org.example.accounts.services.AccountStorageService;
import org.example.accounts.services.InterestCalculator;

import java.util.Calendar;

@Singleton
public class InterestRunnerFacade {

    @Inject
    private AccountStorageService accountStorageService;

    @Inject
    private InterestCalculator interestCalculator;

    public void processAllInterests()
    {
        accountStorageService.getAllBankAccounts().forEach(account -> {
            if (account instanceof SaveAccount saveAccount && saveAccount.getInterestDate().getTimeInMillis() <= System.currentTimeMillis()){
                double interest = interestCalculator.calculateInterest(saveAccount);
                account. setBalance(account.getBalance() + interest);
                (saveAccount).getInterestDate().add(Calendar.MINUTE, 5);
            }
        });
    }
}
