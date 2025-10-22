package org.example.accounts.services;

import org.example.Logger;
import org.example.accounts.BaseBankAccount;

public class AccountBalanceService {

    InputValidationService inputValidationService = new InputValidationService();
    Logger logger = new Logger();

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
