package org.example.persons.customers.serializer.factories;

import jakarta.inject.Singleton;
import org.example.persons.customers.serializer.CustomerSerialization;

@Singleton
public class CustomerSerializationFactory {

    public CustomerSerialization createCustomerSerialization(String uuid, String firstName, String lastName)
    {
        return new CustomerSerialization(uuid, firstName, lastName);
    }
}
