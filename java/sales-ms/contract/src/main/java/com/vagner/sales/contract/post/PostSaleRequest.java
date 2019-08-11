package com.vagner.sales.contract.post;

import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ToString
public class PostSaleRequest {

    @NotNull
    private Integer customerId;
    @Valid
    @NotNull
    private PostDeliveryRequest delivery;
    @Valid
    @NotNull
    private List<PostProductRequest> products;
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
                           PostDeliveryRequest delivery,
                           List<PostProductRequest> products,
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

    public PostDeliveryRequest getDeliveryAddress() {
        return delivery;
    }

    public void setDeliveryAddress(PostDeliveryRequest deliveryAddress) {
        this.delivery = deliveryAddress;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public List<PostProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<PostProductRequest> products) {
        this.products = products;
    }

    public Integer getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Integer creditCardId) {
        this.creditCardId = creditCardId;
    }

    public PostDeliveryRequest getDelivery() {
        return delivery;
    }

    public void setDelivery(PostDeliveryRequest delivery) {
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
                .map(PostProductRequest::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalProducts.add(this.delivery.getFreightPrice()).subtract(this.extraDiscount);
    }
}
