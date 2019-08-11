package com.vagner.sales.contract.post;

import com.vagner.sales.implementation.delivery.DeliveryEntity;

class PostDeliveryMapper {

    public static DeliveryEntity mapFromRequestToEntity(PostDeliveryRequest request) {
        return DeliveryEntity.builder()
                .addressId(request.getAddressId())
                .deliveryDate(request.getDeliveryDate())
                .freightPrice(request.getFreightPrice())
                .build();

    }
}
