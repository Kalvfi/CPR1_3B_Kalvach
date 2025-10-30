package org.example.persons.customers.serializer.services;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.persons.customers.Customer;
import org.example.persons.customers.serializer.CustomerSerialization;
import org.example.persons.customers.serializer.factories.CustomerSerializationFactory;
import org.example.serializer.Serialization;

@Singleton
public class CustomerJsonSerializationService implements Serialization {

    @Inject
    private CustomerSerializationFactory customerSerializationFactory;

    Gson gson = new Gson();

    @Override
    public String serialization(Object customer){
        if (!(customer instanceof Customer)) {
            throw new IllegalArgumentException("Not a Customer object");
        }

        CustomerSerialization ser = customerSerializationFactory.createCustomerSerialization(((Customer) customer).getUuid(),  ((Customer) customer).getFirstName(), ((Customer) customer).getLastName());

        return gson.toJson(ser);
    }

    @Override
    public Customer deserialization(String serialization){

       return gson.fromJson(serialization, Customer.class);
    }
}
