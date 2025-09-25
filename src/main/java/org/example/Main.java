package org.example;


import org.example.accounts.BaseBankAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.generators.AccountNumberGenerator;
import org.example.accounts.services.AccountService;
import org.example.persons.customers.Customer;

public class Main {
    public static void main(String[] args) {

        BankAccountFactory baf = new BankAccountFactory();
        AccountService as = new AccountService();

        Customer customer = new Customer( "c-123", "Filip", "Kalvach");

        BaseBankAccount account = baf.createStudentAccount(
                "u-123",
                customer,
                "DELTA-SŠIE");

        System.out.println("UUID: " + account.getUuid());
        System.out.println("Bank account number: " + account.getBankAccountNumber());
        System.out.println("Customer: " + account.getCustomer().getFullName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Student of: " + ((StudentAccount)account).getStudentOf());

        as.deposit(account, 5000);

        System.out.println("\nBalance after adding: " + account.getBalance());
    }
}