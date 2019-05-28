package com.iesemilidarder.xml.rules.data;

import org.springframework.data.annotation.Id;

/**
 * com.iesemilidarder.xml.rules.data
 * Class Customer
 * 28/05/2019
 *
 * @author berto (alberto.soto@gmail.com)
 */
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}