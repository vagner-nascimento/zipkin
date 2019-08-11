package com.vagner.sales.implementation.customer;

import com.vagner.sales.implementation.data.BaseRepository;
import com.vagner.sales.implementation.data.rest.RestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
class CustomerRepository extends RestClient implements BaseRepository {

    public CustomerRepository() {
        super(":8081/customers/");
    }

    @Override
    public <P> CustomerEntity get(P customerId) {

        return this.callGet(customerId.toString(), CustomerEntity.class).orElse(null);
    }

    @Override
    public <E> CustomerEntity save(E entity) {

        throw new RuntimeException("Not implemented yet");
    }
}