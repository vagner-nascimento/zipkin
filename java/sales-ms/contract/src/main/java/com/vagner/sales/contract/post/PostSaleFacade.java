package com.vagner.sales.contract.post;

import com.vagner.sales.contract.exceptions.BusinessException;
import com.vagner.sales.implementation.customer.CustomerService;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
class PostSaleFacade {

    private CustomerService customerService;

    public PostSaleFacade(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Consumer<Integer> evaluateCustomer() {

        return customerId -> {
            if (!this.customerService.isCustomerActive(customerId))
                throw new BusinessException("Customer is deactivated");
        };
    }
}
