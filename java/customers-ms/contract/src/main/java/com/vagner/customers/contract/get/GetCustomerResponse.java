package com.vagner.customers.contract.get;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class GetCustomerResponse {

    private Integer customerId;
    private String customerName;
    private LocalDateTime deactivationDate;

    public GetCustomerResponse() {
    }

    public GetCustomerResponse(Integer customerId, String customerName, LocalDateTime deactivationDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.deactivationDate = deactivationDate;
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

    public LocalDateTime getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(LocalDateTime deactivationDate) {
        this.deactivationDate = deactivationDate;
    }
}
