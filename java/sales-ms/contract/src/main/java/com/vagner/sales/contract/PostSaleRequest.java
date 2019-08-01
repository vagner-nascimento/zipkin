package com.vagner.sales.contract;

import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ToString
class PostSaleRequest {

    @NotNull
    private Integer customerId;
    @Valid
    @NotNull
    private PostSaleDeliveryRequest delivery;
    @Valid
    @NotNull
    private List<PostSaleProductRequest> products;
    @NotNull
    private LocalDateTime saleDate;
    @NotNull
    private Integer creditCardId;
    @NotNull
    private BigDecimal extraDiscount;
    private String observation;

    public PostSaleRequest() {
    }

    public PostSaleRequest(Integer customerId,
                           PostSaleDeliveryRequest delivery,
                           List<PostSaleProductRequest> products,
                           LocalDateTime saleDate,
                           Integer creditCardId,
                           BigDecimal extraDiscount,
                           String observation) {
        this.customerId = customerId;
        this.delivery = delivery;
        this.products = products;
        this.saleDate = saleDate;
        this.creditCardId = creditCardId;
        this.extraDiscount = extraDiscount;
        this.observation = observation;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public PostSaleDeliveryRequest getDeliveryAddress() {
        return delivery;
    }

    public void setDeliveryAddress(PostSaleDeliveryRequest deliveryAddress) {
        this.delivery = deliveryAddress;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public List<PostSaleProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<PostSaleProductRequest> products) {
        this.products = products;
    }

    public Integer getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Integer creditCardId) {
        this.creditCardId = creditCardId;
    }

    public PostSaleDeliveryRequest getDelivery() {
        return delivery;
    }

    public void setDelivery(PostSaleDeliveryRequest delivery) {
        this.delivery = delivery;
    }

    public BigDecimal getExtraDiscount() {
        return extraDiscount;
    }

    public void setExtraDiscount(BigDecimal extraDiscount) {
        this.extraDiscount = extraDiscount;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public BigDecimal getTotalPrice() {

        BigDecimal totalProducts = this.products.stream()
                .map(PostSaleProductRequest::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalProducts.add(this.delivery.getFreightPrice()).subtract(this.extraDiscount);
    }
}
