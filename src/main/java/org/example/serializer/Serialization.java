package org.example.serializer;

public interface Serialization {

    String serialization(Object serializationObject);
    Object deserialization(String serializationObject);
}
