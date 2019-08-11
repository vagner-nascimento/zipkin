package com.vagner.sales.contract.post;

import com.vagner.sales.contract.exceptions.BusinessException;
import com.vagner.sales.implementation.customer.CustomerService;
import com.vagner.sales.implementation.delivery.DeliveryEntity;
import com.vagner.sales.implementation.delivery.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service
class PostSaleFacade {

    private CustomerService customerService;
    private DeliveryService deliveryService;

    public PostSaleFacade(CustomerService customerService, DeliveryService deliveryService) {
        this.customerService = customerService;
        this.deliveryService = deliveryService;
    }

    public Consumer<PostSaleRequest> evaluateCustomer() {

        return saleRequest -> {

            if (!this.customerService.isCustomerActive(saleRequest.getCustomerId()))
                throw new BusinessException("Customer is deactivated");
        };
    }

    public Consumer<PostSaleRequest> saveDelivery() {

        return saleRequest -> {

            DeliveryEntity delivery = PostDeliveryMapper.mapFromRequestToEntity(saleRequest.getDelivery());
            DeliveryEntity savedDelivery = this.deliveryService.save(delivery);
            log.info(savedDelivery.toString());
        };
    }
}