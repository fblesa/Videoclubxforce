package com.iesemilidarder.xml.rules;

import com.iesemilidarder.xml.rules.data.User;
import com.iesemilidarder.xml.rules.repository.CustomRepository;
import com.iesemilidarder.xml.rules.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * com.iesemilidarder.xml.rules
 * Class ConsoleApplication
 * 28/05/2019
 *
 *
 * Inspired on https://www.opencodez.com/java/use-mongodb-atlas-with-spring-boot.htm
 * @author berto (alberto.soto@gmail.com)
 */
@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    @Autowired
    CustomRepository crepo;

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        deleteAll();
        addSampleData();
        listAll();
        findFirst();
        findByRegex();
    }

    public void deleteAll() {
        System.out.println("Deleting all records..");
        repository.deleteAll();
    }

    public void addSampleData() {
        System.out.println("Adding sample data");
        repository.save(new User("Jack Bauer", "New York", 11111d));
        repository.save(new User("Harvey Spectre", "London", 22222d));
        repository.save(new User("Mike Ross", "New Jersey", 333333d));
        repository.save(new User("Louise Litt", "Kathmandu", 44444d));
    }

    public void listAll() {
        System.out.println("Listing sample data");
        repository.findAll().forEach(u -> System.out.println(u));
    }

    public void findFirst() {
        System.out.println("Finding first by Name");
        User u = repository.findFirstByName("Louise Litt");
        System.out.println(u);
    }

    public void findByRegex() {
        System.out.println("Finding by Regex - All with address starting with ^New");
        repository.findCustomByRegExAddress("^New").forEach(u -> System.out.println(u));
    }
}