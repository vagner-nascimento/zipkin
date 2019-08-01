package com.vagner.sales.contract;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class SaleController {

    @Autowired
    private SaleService saleFacade;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostSaleResponse postSale(@RequestBody PostSaleRequest postSaleRequest) {
        log.info(postSaleRequest.toString());
        return saleFacade.doSale(postSaleRequest);
    }
}