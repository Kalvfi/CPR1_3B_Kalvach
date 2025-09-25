package org.example.accounts.services;

import org.example.accounts.BaseBankAccount;

public class AccountService {

    InputValidationService ivs = new InputValidationService();

    public void deposit(BaseBankAccount account, double amount) {
        ivs.checkPositiveAmount(account.getBalance());
        ivs.checkMaxAmount(account.getBalance());

        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        ivs.checkPositiveAmount(account.getBalance());
        ivs.checkFinalAmount(account.getBalance(), amount);

        account.setBalance(account.getBalance() - amount);
    }

}
