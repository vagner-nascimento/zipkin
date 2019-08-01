package com.vagner.customers.contract;

import com.vagner.customers.contract.get.GetCustomerResponse;
import com.vagner.customers.contract.get.GetCustomerService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
public class SaleController {

    @Autowired
    private GetCustomerService getCustomerService;

    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetCustomerResponse getCustomer(@PathVariable @NotNull @Min(1) Integer customerId) {

        return getCustomerService.getCustomer(customerId);
    }
}