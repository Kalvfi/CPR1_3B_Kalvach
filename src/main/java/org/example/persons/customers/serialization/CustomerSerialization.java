package org.example.persons.customers.serialization;

public class CustomerSerialization {

    public String uuid;
    public String firstName;
    public String lastName;

    public CustomerSerialization(String uuid, String firstName, String lastName) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
