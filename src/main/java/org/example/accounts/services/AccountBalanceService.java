package org.example.accounts.services;

import org.example.accounts.BaseBankAccount;

public class AccountBalanceService {

    InputValidationService ivs = new InputValidationService();

    public void deposit(BaseBankAccount account, double amount) {
        ivs.checkPositiveAmount(amount);
        ivs.checkMaxAmount(amount);

        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        ivs.checkPositiveAmount(amount);
        ivs.checkFinalAmount(account.getBalance(), amount);

        account.setBalance(account.getBalance() - amount);
    }

}
