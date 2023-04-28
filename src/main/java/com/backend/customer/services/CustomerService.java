package com.backend.customer.services;
import java.util.List;
import com.backend.customer.models.Customer;
import com.backend.customer.repositories.LocalCustomerDataAccess;

public class CustomerService {
    private final LocalCustomerDataAccess _customerDB;

    public CustomerService(LocalCustomerDataAccess CustomerDB){
        this._customerDB = CustomerDB;
    }

    public List<Customer> GetAllCustomers (){
        var customers = this._customerDB.GetAll();
        return customers;
    }

    public Customer GetCustomerById (Integer customerId) {
        var optionalCustomer = this._customerDB.GetById(customerId);
        return optionalCustomer
                .map(customer ->  new Customer(
                            customer.getId(),
                            customer.getAge(),
                            customer.getName(),
                            customer.getEmail(),
                            customer.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("no customer with given id"));
    }
}
