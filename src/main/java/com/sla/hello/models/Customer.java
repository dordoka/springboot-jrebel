package com.sla.hello.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    protected Customer() {}

    public Customer(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d first=%s last=%s]",
                id,
                firstName,
                lastName);
    }
}
