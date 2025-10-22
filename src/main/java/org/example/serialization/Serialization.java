package org.example.serialization;

public interface Serialization {

    String serialization(Object serializationObject);
    Object deserialization(String serializationObject);
}
