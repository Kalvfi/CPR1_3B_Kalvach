package org.example.accounts.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.Logger;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.entries.enums.ActionType;
import org.example.entries.factories.EntryFactory;

@Singleton
public class AccountTransferService {

    @Inject
    private InputValidationService inputValidationService;

    @Inject
    private Logger logger;

    @Inject
    private EntryFactory entryFactory;

    @Inject
    private InterestCalculator interestCalculator;

    public void deposit(BaseBankAccount account, double amount) {
        inputValidationService.checkPositiveAmount(amount);
        inputValidationService.checkMaxAmount(amount);

        account.setBalance(account.getBalance() + amount);
        logger.logDeposit(amount, account);
        account.getAccountTransferEntries().add(entryFactory.createAccountTransferRecord(ActionType.DEPOSIT, amount));
    }

    public void withdraw(BaseBankAccount account, double amount) {
        inputValidationService.checkPositiveAmount(amount);
        inputValidationService.checkFinalAmount(account.getBalance(), amount);

        account.setBalance(account.getBalance() - amount);
        logger.logWithdrawal(amount, account);
        account.getAccountTransferEntries().add(entryFactory.createAccountTransferRecord(ActionType.WITHDRAWAL, amount));
    }

    public void interest(SaveAccount saveAccount) {
        double interest = interestCalculator.calculateInterest(saveAccount);
        saveAccount.setBalance(saveAccount.getBalance() + interest);
        logger.logInterest(interest, saveAccount);
        saveAccount.getAccountTransferEntries().add(entryFactory.createAccountTransferRecord(ActionType.INTEREST, interest));
    }

}
