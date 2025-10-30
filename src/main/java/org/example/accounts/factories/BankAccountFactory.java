package org.example.accounts.factories;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.generators.AccountNumberGenerator;
import org.example.accounts.services.AccountStorageService;
import org.example.persons.customers.Customer;

import java.util.UUID;

@Singleton
public class BankAccountFactory {

    @Inject
    private AccountNumberGenerator accountNumberGenerator;

    @Inject
    private AccountStorageService accountStorageService;

    public StudentAccount createStudentAccount(Customer customer, String studentOf) {
        String accountNumber = accountNumberGenerator.generateAccountNumber();
        String uuid = UUID.randomUUID().toString();

        StudentAccount studentAccount = new StudentAccount(uuid, accountNumber, customer, studentOf);
        accountStorageService.getAllBankAccounts().add(studentAccount);
        customer.getBankAccounts().add(studentAccount);
        return studentAccount;
    }

    public BankAccount createBankAccount(Customer customer) {
        String accountNumber = accountNumberGenerator.generateAccountNumber();
        String uuid = UUID.randomUUID().toString();

        BankAccount bankAccount = new BankAccount(uuid, accountNumber, customer);
        accountStorageService.getAllBankAccounts().add(bankAccount);
        customer.getBankAccounts().add(bankAccount);
        return bankAccount;
    }

    public SaveAccount createSaveAccount(Customer customer, float interestRate) {
        String accountNumber = accountNumberGenerator.generateAccountNumber();
        String uuid = UUID.randomUUID().toString();

        SaveAccount saveAccount = new SaveAccount(uuid, accountNumber, customer, interestRate);
        accountStorageService.getAllBankAccounts().add(saveAccount);
        customer.getBankAccounts().add(saveAccount);
        return saveAccount;
    }
}
