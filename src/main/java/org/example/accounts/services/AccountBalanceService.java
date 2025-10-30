package org.example.accounts.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.Logger;
import org.example.accounts.BaseBankAccount;

@Singleton
public class AccountBalanceService {

    @Inject
    private InputValidationService inputValidationService;

    @Inject
    private Logger logger;

    public void deposit(BaseBankAccount account, double amount) {
        inputValidationService.checkPositiveAmount(amount);
        inputValidationService.checkMaxAmount(amount);

        account.setBalance(account.getBalance() + amount);
        logger.logDeposit(amount, account);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        inputValidationService.checkPositiveAmount(amount);
        inputValidationService.checkFinalAmount(account.getBalance(), amount);

        account.setBalance(account.getBalance() - amount);
        logger.logWithdrawal(amount, account);
    }

}
