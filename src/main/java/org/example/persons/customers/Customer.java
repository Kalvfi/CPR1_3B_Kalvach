package org.example.persons.customers;

import org.example.accounts.BaseBankAccount;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String uuid;
    private final String firstName;
    private final String lastName;

    private List<BaseBankAccount> bankAccounts =  new ArrayList<BaseBankAccount>();

    public Customer(String uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public List<BaseBankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
