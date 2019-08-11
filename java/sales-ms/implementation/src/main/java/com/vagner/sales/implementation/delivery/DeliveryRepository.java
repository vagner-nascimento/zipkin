package com.vagner.sales.implementation.delivery;

import com.vagner.sales.implementation.data.BaseRepository;
import com.vagner.sales.implementation.data.rest.RestClient;
import org.springframework.stereotype.Repository;

@Repository
class DeliveryRepository extends RestClient implements BaseRepository {

    public DeliveryRepository() {
        super(":8082/deliveries/");
    }

    @Override
    public <P> Object get(P param) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public <E> Object save(E entity) {
        return this.callPost(null, DeliveryEntity.class, entity)
                .orElseThrow(() -> new RuntimeException("Something goes wrong on 'saveDelivery'"));
    }
}