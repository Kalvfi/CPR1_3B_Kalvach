package org.example.persons.customers.serialization.factories;

import org.example.persons.customers.serialization.CustomerSerialization;

public class CustomerSerializationFactory {

    public CustomerSerialization createCustomerSerialization(String uuid, String firstName, String lastName)
    {
        return new CustomerSerialization(uuid, firstName, lastName);
    }
}
