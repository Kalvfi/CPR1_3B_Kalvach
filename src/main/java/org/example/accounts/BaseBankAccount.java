package org.example.accounts;

import org.example.persons.customers.Customer;

public class BaseBankAccount {

    private final String uuid;

    private final String bankAccountNumber;

    private final Customer customer;

    private double balance;

    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
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

    public void addBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance += balance;
    }

    public void subBalance(double balance) {
        double finalBalance = this.balance - balance;
        if(finalBalance <= 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        else  {
            this.balance = finalBalance;
        }
    }
}
