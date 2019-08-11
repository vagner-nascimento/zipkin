package com.vagner.sales.implementation.delivery;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private DeliveryRepository repository;

    public DeliveryService(DeliveryRepository repository) {
        this.repository = repository;
    }

    public DeliveryEntity save(DeliveryEntity delivery) {

        return (DeliveryEntity)this.repository.save(delivery);
    }
}