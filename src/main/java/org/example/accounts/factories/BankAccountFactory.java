package org.example.accounts.factories;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.generators.AccountNumberGenerator;
import org.example.persons.customers.Customer;

public class BankAccountFactory {

    AccountNumberGenerator ang = new AccountNumberGenerator();

    public BaseBankAccount createBaseBankAccount(String uuid, Customer customer, double balance) {
        String accountNumber = ang.generateAccountNumber();

        return new BaseBankAccount(uuid, accountNumber, customer, balance);
    }

    public StudentAccount createStudentAccount(String uuid, Customer customer, String studentOf) {
        String accountNumber = ang.generateAccountNumber();

        return new StudentAccount(uuid, accountNumber, customer, studentOf);
    }

    public BankAccount createBankAccount(String uuid, Customer customer) {
        String accountNumber = ang.generateAccountNumber();

        return new BankAccount(uuid, accountNumber, customer);
    }

    public SaveAccount createSaveAccount(String uuid, Customer customer, float interestRate) {
        String accountNumber = ang.generateAccountNumber();

        return new SaveAccount(uuid, accountNumber, customer, interestRate);
    }
}
