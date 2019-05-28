package com.iesemilidarder.xml.rules.service;

import com.iesemilidarder.xml.rules.data.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
/**
 * com.iesemilidarder.xml.rules.service
 * Class CustomerRepository
 * 28/05/2019
 *
 * @author berto (alberto.soto@gmail.com)
 */

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}