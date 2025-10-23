package org.example.accounts.factories;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.generators.AccountNumberGenerator;
import org.example.persons.customers.Customer;

import java.util.UUID;

public class BankAccountFactory {

    AccountNumberGenerator accountNumberGenerator;

    public BankAccountFactory(AccountNumberGenerator accountNumberGenerator) {
        this.accountNumberGenerator = accountNumberGenerator;
    }

    public BaseBankAccount createBaseBankAccount(Customer customer, double balance) {
        String accountNumber = accountNumberGenerator.generateAccountNumber();
        String uuid = UUID.randomUUID().toString();

        return new BaseBankAccount(uuid, accountNumber, customer, balance);
    }

    public StudentAccount createStudentAccount(Customer customer, String studentOf) {
        String accountNumber = accountNumberGenerator.generateAccountNumber();
        String uuid = UUID.randomUUID().toString();

        return new StudentAccount(uuid, accountNumber, customer, studentOf);
    }

    public BankAccount createBankAccount(Customer customer) {
        String accountNumber = accountNumberGenerator.generateAccountNumber();
        String uuid = UUID.randomUUID().toString();

        return new BankAccount(uuid, accountNumber, customer);
    }

    public SaveAccount createSaveAccount(Customer customer, float interestRate) {
        String accountNumber = accountNumberGenerator.generateAccountNumber();
        String uuid = UUID.randomUUID().toString();

        return new SaveAccount(uuid, accountNumber, customer, interestRate);
    }
}
