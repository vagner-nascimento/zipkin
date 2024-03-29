package com.vagner.sales.contract.post;

import lombok.Builder;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString
@Builder
class PostDeliveryRequest {

    @NotNull
    private Integer addressId;
    @NotNull
    private LocalDateTime deliveryDate;
    @NotNull
    private BigDecimal freightPrice;

    public PostDeliveryRequest() {
    }

    public PostDeliveryRequest(Integer addressId, LocalDateTime deliveryDate, BigDecimal freightPrice) {
        this.addressId = addressId;
        this.deliveryDate = deliveryDate;
        this.freightPrice = freightPrice;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }
}