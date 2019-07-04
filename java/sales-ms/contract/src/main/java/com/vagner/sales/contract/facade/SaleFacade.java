package com.vagner.sales.contract.facade;

import com.vagner.sales.contract.model.response.PostSaleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vagner.sales.contract.model.request.PostSale;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class SaleFacade {

    @Autowired
    private RestTemplate restTemplate;

    public PostSaleResponse doSale(PostSale postSale) {

        return PostSaleResponse.builder()
                .orderNumber(Math.abs(ThreadLocalRandom.current().nextLong()))
                .build();
    }
}
