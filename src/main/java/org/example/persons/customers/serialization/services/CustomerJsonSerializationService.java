package org.example.persons.customers.serialization.services;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.persons.customers.Customer;
import org.example.persons.customers.serialization.CustomerSerialization;
import org.example.persons.customers.serialization.factories.CustomerSerializationFactory;
import org.example.serialization.Serialization;

@Singleton
public class CustomerJsonSerializationService implements Serialization {

    @Inject
    private CustomerSerializationFactory customerSerializationFactory;

    Gson gson = new Gson();

    public String serialization(Object customer){
        if (!(customer instanceof Customer)) {
            throw new IllegalArgumentException("Not a Customer object");
        }

        CustomerSerialization ser = customerSerializationFactory.createCustomerSerialization(((Customer) customer).getUuid(),  ((Customer) customer).getFirstName(), ((Customer) customer).getLastName());

        return gson.toJson(ser);
    }

    public Customer deserialization(String serialization){

       return gson.fromJson(serialization, Customer.class);
    }
}
