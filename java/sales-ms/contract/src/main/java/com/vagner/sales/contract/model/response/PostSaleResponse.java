package com.vagner.sales.contract.model.response;

import lombok.Builder;

@Builder
public class PostSaleResponse {

    private Long orderNumber;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
