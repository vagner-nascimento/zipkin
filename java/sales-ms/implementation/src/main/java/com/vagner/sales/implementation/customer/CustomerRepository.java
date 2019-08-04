package com.vagner.sales.implementation.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Repository
class CustomerRepository {

    private RestTemplate restTemplate;

    public CustomerRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${ms.base.url}")
    private String BASE_URL;
    private final String CUSTOMER_URL = ":8081/customers/";

    public Boolean isCustomerActive(Integer customerId) {

        try {
            var path = String.format("%s%s%s", BASE_URL, CUSTOMER_URL, customerId);
            var response = restTemplate.getForEntity(path, CustomerEntity.class).getBody();

            return Objects.isNull(response.getDeactivationDate());
        } catch (HttpClientErrorException httpEx) {

            if (httpEx.getStatusCode().equals(HttpStatus.NOT_FOUND)) return false;

            log.error("Error", httpEx);

            throw httpEx;
        } catch (Exception ex) {

            log.error("Error", ex);

            throw ex;
        }
    }
}