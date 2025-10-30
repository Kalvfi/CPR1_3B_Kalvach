package org.example.accounts;

import org.example.persons.customers.Customer;

import java.util.Calendar;

public class SaveAccount extends BaseBankAccount{

    private float interestRate;
    private Calendar interestDate;

    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, float interestRate) {
        super(uuid, bankAccountNumber, customer, 0);
        this.interestRate = interestRate;
        Calendar interestDate = Calendar.getInstance();
        interestDate.add(Calendar.MINUTE, 5);
        this.interestDate = interestDate;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public Calendar getInterestDate() {
        return interestDate;
    }
}
