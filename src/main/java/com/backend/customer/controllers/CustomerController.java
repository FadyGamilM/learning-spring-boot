package com.backend.customer.controllers;

import com.backend.customer.models.Customer;
import com.backend.customer.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    // DI
    private final CustomerService _customerService;

    public CustomerController(CustomerService CustomerService) {
        this._customerService = CustomerService;
    }

    @GetMapping("api/v1/customers")
    public List<Customer> GetCustomers() {
        return this._customerService.GetAllCustomers();
    }

    @GetMapping("/api/v1/customers/{customerId}")
    public Customer GetCustomerById (@PathVariable("customerId") Integer customerId){
        return this._customerService.GetCustomerById(customerId);
    }
}
