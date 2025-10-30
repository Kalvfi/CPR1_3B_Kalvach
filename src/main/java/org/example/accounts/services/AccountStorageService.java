package org.example.accounts.services;

import jakarta.inject.Singleton;
import org.example.accounts.BaseBankAccount;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class AccountStorageService {
    static List<BaseBankAccount> allBankAccounts = new ArrayList<BaseBankAccount>();

    public List<BaseBankAccount> getAllBankAccounts() {
        return allBankAccounts;
    }

    public BaseBankAccount getAccountByAccountNumber(String bankAccountNumber) {
        for (BaseBankAccount bankAccount : allBankAccounts) {
            if (bankAccount.getBankAccountNumber().equals(bankAccountNumber)) {
                return bankAccount;
            }
        }
        throw new IllegalArgumentException();
    }
}
