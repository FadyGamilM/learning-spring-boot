package com.backend.customer.abstractions;

import com.backend.customer.models.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    // Get All Customers
    List<Customer> GetAll();

    // Get Customer By Id
    Optional<Customer> GetById(Integer customerId);
}
