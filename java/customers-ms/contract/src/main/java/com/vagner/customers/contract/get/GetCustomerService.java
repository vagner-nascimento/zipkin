package com.vagner.customers.contract.get;

import org.springframework.stereotype.Service;

@Service
public class GetCustomerService {

    public GetCustomerResponse getCustomer(Integer customerId){

        return GetCustomerResponse.builder()
                .customerId(customerId)
                .customerName("Mr. Gatsby")
                .deactivationDate(null)
                .build();
    }
}
