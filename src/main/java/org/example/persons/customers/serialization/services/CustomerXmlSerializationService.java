package org.example.persons.customers.serialization.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.persons.customers.Customer;
import org.example.persons.customers.serialization.CustomerSerialization;
import org.example.persons.customers.serialization.factories.CustomerSerializationFactory;
import org.example.serialization.Serialization;

@Singleton
public class CustomerXmlSerializationService implements Serialization {

    @Inject
    private CustomerSerializationFactory customerSerializationFactory;

    XmlMapper xmlMapper = new XmlMapper();

    public String serialization(Object customer){
        if (!(customer instanceof Customer)) {
            throw new IllegalArgumentException("Not a Customer object");
        }

        CustomerSerialization ser = customerSerializationFactory.createCustomerSerialization(((Customer) customer).getUuid(),  ((Customer) customer).getFirstName(), ((Customer) customer).getLastName());

        try {
            return xmlMapper.writeValueAsString(ser);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer deserialization(String serialization){
        return xmlMapper.convertValue(serialization, Customer.class);
    }
}
