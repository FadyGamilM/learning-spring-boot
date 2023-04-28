package com.backend.customer.repositories;

import com.backend.customer.abstractions.CustomerDao;
import com.backend.customer.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocalCustomerDataAccess implements CustomerDao {
    // Local DB
    private static List<Customer> CustomerDB = new ArrayList<Customer>();

    // initialize the database (seeding)
    static {
        var c1 = new Customer(1, 25, "fady gamil", "fady@gmail.com", "123456789");
        var c2 = new Customer(2, 25, "fady mokhtar", "fady@gmail.com", "852456753");
        var c3 = new Customer(3, 23, "samy samaan", "samy@gmail.com", "123456952");
        var c4 = new Customer(4, 20, "magy magdy", "magy@gmail.com", "159357654");
        var c5 = new Customer(5, 24, "ahmed ayman", "ahmed@gmail.com", "1zx4fas89");

        CustomerDB.addAll(List.of(c1, c2, c3, c4, c5));
        System.out.println("database seeding is done successfully !");
    }


    public List<Customer> GetAll(){
        return CustomerDB;
    }

    public Optional<Customer> GetById(Integer customerId){
        var customer = CustomerDB.stream()
                .filter(C -> C.getId() == customerId.intValue())
                .findFirst();
        return customer;
    }
}
