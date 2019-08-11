package com.vagner.sales.contract.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class PostSaleService {

    private PostSaleFacade customerFacade;

    public PostSaleService(PostSaleFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    public PostSaleResponse doSale(PostSaleRequest postSaleRequest) {

        customerFacade.evaluateCustomer()
                .andThen(customerFacade.saveDelivery())
                .accept(postSaleRequest);

        return PostSaleResponse.builder()
                .orderNumber(Math.abs(ThreadLocalRandom.current().nextLong()))
                .build();
    }
}