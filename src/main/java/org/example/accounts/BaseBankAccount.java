package org.example.accounts;

import org.example.persons.customers.Customer;
import org.example.entries.AccountTransferEntry;

import java.util.ArrayList;
import java.util.List;

public class BaseBankAccount {

    private final String uuid;

    private final String bankAccountNumber;

    private final Customer customer;

    private double balance;

    private List<AccountTransferEntry> accountTransferEntries;

    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
        this.accountTransferEntries = new ArrayList<AccountTransferEntry>();
    }

    public String getUuid() {
        return uuid;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<AccountTransferEntry> getAccountTransferEntries() {
        return accountTransferEntries;
    }
}
