package org.example.persons.customers.factories;

import jakarta.inject.Singleton;
import org.example.persons.customers.Customer;

import java.util.UUID;

@Singleton
public class CustomerFactory {
    public Customer createCustomer(String firstName, String lastName){
        String uuid = UUID.randomUUID().toString();

        return new Customer(uuid, firstName, lastName);
    }
}
