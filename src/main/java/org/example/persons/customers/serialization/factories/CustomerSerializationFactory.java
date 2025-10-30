package org.example.persons.customers.serialization.factories;

import jakarta.inject.Singleton;
import org.example.persons.customers.serialization.CustomerSerialization;

@Singleton
public class CustomerSerializationFactory {

    public CustomerSerialization createCustomerSerialization(String uuid, String firstName, String lastName)
    {
        return new CustomerSerialization(uuid, firstName, lastName);
    }
}
