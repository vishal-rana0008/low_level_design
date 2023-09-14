package com.interview.interview3.repository;

import com.interview.interview3.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository {
    // customerName
    private Map<String, Customer> customerMap = new HashMap<>();

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getCustomerName(), customer);
    }

    public Customer getCustomer(String customerName) {
        return customerMap.get(customerName);
    }
}
