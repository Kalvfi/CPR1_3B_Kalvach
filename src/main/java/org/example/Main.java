package org.example;


import org.example.accounts.BaseBankAccount;
import org.example.accounts.StudentAccount;
import org.example.persons.customers.Customer;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer( "c-123", "Filip", "Kalvach");

        BaseBankAccount account = new StudentAccount( "u-123", "12345", customer, "DELTA-SŠIE");

        System.out.println("UUID: " + account.getUuid());
        System.out.println("Bank account number: " + account.getBankAccountNumber());
        System.out.println("Customer: " + account.getCustomer().getFullName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Student Of: " + ((StudentAccount)account).getStudentOf());



    }
}