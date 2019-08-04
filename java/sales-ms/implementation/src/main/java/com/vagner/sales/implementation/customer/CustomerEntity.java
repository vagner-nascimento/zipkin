package com.vagner.sales.implementation.customer;

import java.time.LocalDateTime;

public class CustomerEntity {
    private Integer customerId;
    private String customerName;
    private LocalDateTime deactivationDate;

    public CustomerEntity() {
    }

    public CustomerEntity(Integer customerId, String customerName, LocalDateTime deactivationDate) {
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