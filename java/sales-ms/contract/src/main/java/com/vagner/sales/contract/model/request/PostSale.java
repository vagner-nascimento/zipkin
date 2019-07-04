package com.vagner.sales.contract.model.request;

import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ToString
public class PostSale {

    @NotNull
    private Integer customerId;
    @Valid
    @NotNull
    private PostSaleDelivery delivery;
    @Valid
    @NotNull
    private List<PostSaleProduct> products;
    @NotNull
    private LocalDateTime saleDate;
    @NotNull
    private Integer creditCardId;
    @NotNull
    private BigDecimal extraDiscount;
    private String observation;

    public PostSale() {
    }

    public PostSale(Integer customerId,
                    PostSaleDelivery delivery,
                    List<PostSaleProduct> products,
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

    public PostSaleDelivery getDeliveryAddress() {
        return delivery;
    }

    public void setDeliveryAddress(PostSaleDelivery deliveryAddress) {
        this.delivery = deliveryAddress;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public List<PostSaleProduct> getProducts() {
        return products;
    }

    public void setProducts(List<PostSaleProduct> products) {
        this.products = products;
    }

    public Integer getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Integer creditCardId) {
        this.creditCardId = creditCardId;
    }

    public PostSaleDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(PostSaleDelivery delivery) {
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
                .map(PostSaleProduct::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalProducts.add(this.delivery.getFreightPrice()).subtract(this.extraDiscount);
    }
}
