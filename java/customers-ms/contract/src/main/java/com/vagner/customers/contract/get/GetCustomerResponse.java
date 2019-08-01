package com.vagner.customers.contract.get;

import lombok.Builder;

@Builder
public class GetCustomerResponse {

    private Integer customerId;
    private String customerName;

    public GetCustomerResponse() {
    }

    public GetCustomerResponse(Integer customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
