package com.vagner.sales.implementation.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Boolean isCustomerActive(Integer customerId) {

        return repository.isCustomerActive((customerId));
    }
}