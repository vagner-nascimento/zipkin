package com.vagner.sales.contract.model.request;

import lombok.Builder;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ToString
@Builder
public class PostSaleProduct {

    @NotNull
    private Integer id;
    @NotNull
    private Integer quantity;
    @NotNull
    private BigDecimal unitPrice;
    @NotNull
    private BigDecimal discountValue;

    public PostSaleProduct() {
    }

    public PostSaleProduct(Integer id, Integer quantity, BigDecimal unitPrice, BigDecimal discountValue) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discountValue = discountValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return this.unitPrice.multiply(BigDecimal.valueOf(this.quantity)).subtract(this.discountValue);
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }
}
