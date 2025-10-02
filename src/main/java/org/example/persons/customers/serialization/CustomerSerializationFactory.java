package org.example.persons.customers.serialization;

public class CustomerSerializationFactory {

    public CustomerSerialization createCustomerSerialization(String uuid, String firstName, String lastName)
    {
        return new CustomerSerialization(uuid, firstName, lastName);
    }
}
