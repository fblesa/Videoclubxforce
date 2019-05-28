package com.iesemilidarder.xml.rules.repository;

import com.iesemilidarder.xml.rules.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * com.iesemilidarder.xml.rules.service
 * Class UserRepository
 * 28/05/2019
 *
 * @author berto (alberto.soto@gmail.com)
 */

public interface UserRepository extends MongoRepository<User, String> {

    User findFirstByName(String name);

    @Query("{address:'?0'}")
    List<User> findCustomByAddress(String address);

    @Query("{address : { $regex: ?0 } }")
    List<User> findCustomByRegExAddress(String domain);

}