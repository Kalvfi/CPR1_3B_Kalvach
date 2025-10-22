package org.example.persons.customers.serialization.services;

import com.google.gson.Gson;
import org.example.persons.customers.Customer;
import org.example.persons.customers.serialization.CustomerSerialization;
import org.example.persons.customers.serialization.factories.CustomerSerializationFactory;
import org.example.serialization.Serialization;

public class CustomerJsonSerializationService implements Serialization {

    CustomerSerializationFactory customerSerializationFactory = new CustomerSerializationFactory();
    Gson gson = new Gson();

    @Override
    public String serialization(Object customer){
        if (!(customer instanceof Customer)) {
            throw new IllegalArgumentException("Not a Customer object");
        }

        CustomerSerialization ser = customerSerializationFactory.createCustomerSerialization(((Customer) customer).getUuid(),  ((Customer) customer).getFirstName(), ((Customer) customer).getLastName());

        /*
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"uuid\":\"").append(ser.uuid).append("\",");
        sb.append("\"firstName\":\"").append(ser.firstName).append("\",");
        sb.append("\"lastName\":\"").append(ser.lastName).append("\"");
        sb.append("}");
        */

        return gson.toJson(ser);
    }

    @Override
    public Customer deserialization(String serialization){

       return gson.fromJson(serialization, Customer.class);
    }
}
