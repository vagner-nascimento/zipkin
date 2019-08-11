package com.vagner.sales.implementation.delivery;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public class DeliveryEntity {

    private Integer deliveryId;
    private Integer addressId;
    private LocalDateTime deliveryDate;
    private BigDecimal freightPrice;

    public DeliveryEntity() {
    }

    public DeliveryEntity(Integer deliveryId, Integer addressId, LocalDateTime deliveryDate, BigDecimal freightPrice) {
        this.deliveryId = deliveryId;
        this.addressId = addressId;
        this.deliveryDate = deliveryDate;
        this.freightPrice = freightPrice;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
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