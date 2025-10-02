package org.example.persons.customers.serialization;

public interface Serialization {

    String serialization(Object serializationObject);
    Object deserialization(String serializationObject);
}
