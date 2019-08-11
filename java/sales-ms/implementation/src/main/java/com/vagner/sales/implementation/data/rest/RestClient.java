package com.vagner.sales.implementation.data.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
public abstract class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ms.base.url}")
    private String BASE_URL;
    private String PATH;

    public RestClient(String msPath) {
        this.PATH = msPath;
    }

    private String getCompleteUrl(String params) {

        return this.BASE_URL.concat(this.PATH).concat(Optional.ofNullable(params).orElse(""));
    }

    protected <T> Optional<T> callGet(String parms, Class<T> responseType) {

        try {
            return Optional
                    .ofNullable(this.restTemplate.getForEntity(this.getCompleteUrl(parms), responseType).getBody());
        } catch (HttpClientErrorException httpEx) {

            if (httpEx.getStatusCode().equals(HttpStatus.NOT_FOUND)) return Optional.empty();

            throw httpEx;
        }
    }

    protected <T> Optional<T> callPost(String parms, Class<T> responseType, Object requestBody) {

        return Optional.ofNullable(
                this.restTemplate.postForEntity(
                        this.getCompleteUrl((parms)),
                        requestBody,
                        responseType
                ).getBody()
        );
    }
}