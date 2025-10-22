package org.example.persons.customers.serialization.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.persons.customers.Customer;
import org.example.persons.customers.serialization.CustomerSerialization;
import org.example.persons.customers.serialization.factories.CustomerSerializationFactory;
import org.example.serialization.Serialization;

public class CustomerXmlSerializationService implements Serialization {

    CustomerSerializationFactory customerSerializationFactory = new CustomerSerializationFactory();

    XmlMapper xmlMapper = new XmlMapper();

    @Override
    public String serialization(Object customer){
        if (!(customer instanceof Customer)) {
            throw new IllegalArgumentException("Not a Customer object");
        }

        CustomerSerialization ser = customerSerializationFactory.createCustomerSerialization(((Customer) customer).getUuid(),  ((Customer) customer).getFirstName(), ((Customer) customer).getLastName());

        /*
        StringBuilder sb = new StringBuilder();
        sb.append("<Customer>");
        sb.append("<Uuid>").append(ser.uuid).append("</Uuid>");
        sb.append("<FirstName>").append(ser.firstName).append("</FirstName>");
        sb.append("<LastName>").append(ser.lastName).append("</LastName>");
        sb.append("</Customer>");
        return sb.toString();
        */

        try {
            return xmlMapper.writeValueAsString(ser);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer deserialization(String serialization){
        return xmlMapper.convertValue(serialization, Customer.class);
    }
}
