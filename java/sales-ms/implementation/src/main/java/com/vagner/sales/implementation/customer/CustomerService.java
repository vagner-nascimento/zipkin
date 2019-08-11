package com.vagner.sales.implementation.customer;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Boolean isCustomerActive(Integer customerId) {

        return Optional.ofNullable(this.repository.get(customerId))
                .map(customer -> Objects.isNull(customer.getDeactivationDate()))
                .orElse(false);
    }
}