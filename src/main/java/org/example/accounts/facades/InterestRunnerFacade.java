package org.example.accounts.facades;


import jakarta.inject.Inject;
import org.example.accounts.SaveAccount;
import org.example.accounts.services.AccountStorageService;
import org.example.accounts.services.InterestCalculator;

public class InterestRunnerFacade {

    @Inject
    private AccountStorageService accountStorageService;

    @Inject
    private InterestCalculator interestCalculator;

    public void processAllInterests()
    {
        accountStorageService.getAllBankAccounts().forEach(account -> {
            if (account instanceof SaveAccount){
                double interest = interestCalculator.calculateInterest((SaveAccount)account);
                account. setBalance(account.getBalance() + interest);
            }
        });
    }
}
