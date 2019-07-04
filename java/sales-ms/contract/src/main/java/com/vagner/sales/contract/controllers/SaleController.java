package com.vagner.sales.contract.controllers;

import com.vagner.sales.contract.facade.SaleFacade;
import com.vagner.sales.contract.model.request.PostSale;
import com.vagner.sales.contract.model.response.PostSaleResponse;
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
    private SaleFacade saleFacade;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PostSaleResponse postSale(@RequestBody @Valid PostSale postSale) {
        log.info(postSale.toString());
        return saleFacade.doSale(postSale);
    }
}
