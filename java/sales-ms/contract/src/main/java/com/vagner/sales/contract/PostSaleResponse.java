package com.vagner.sales.contract;

import lombok.Builder;

@Builder
class PostSaleResponse {

    private Long orderNumber;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
