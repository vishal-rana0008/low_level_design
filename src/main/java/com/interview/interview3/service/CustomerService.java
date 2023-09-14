package com.interview.interview3.service;

import com.interview.interview3.model.Customer;
import com.interview.interview3.repository.CustomerRepository;

public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(String customerName) {
        customerRepository.addCustomer(new Customer(customerName));
    }
}
