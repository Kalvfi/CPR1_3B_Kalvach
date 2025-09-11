package org.example.accounts;

import org.example.persons.customers.Customer;

public class StudentAccount extends BankAccount{

    private final String studentOf;

    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, String studentOf) {
        super(uuid, bankAccountNumber, customer);
        this.studentOf = studentOf;
    }

    public String getStudentOf() {
        return studentOf;
    }
}
