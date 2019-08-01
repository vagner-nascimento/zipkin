package com.vagner.sales.contract;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
class SaleService {

    @Autowired
    private RestTemplate restTemplate;

    public PostSaleResponse doSale(PostSaleRequest postSaleRequest) {

        return PostSaleResponse.builder()
                .orderNumber(Math.abs(ThreadLocalRandom.current().nextLong()))
                .build();
    }
}