package com.vagner.customers.contract.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetCustomerServiceTest {

    private GetCustomerService service = new GetCustomerService();

    @Test
    @DisplayName("When sent id should return customer with same id")
    void getCustomer_WhenSentId_ShouldReturnCustomerWithSameId() {

        var result = service.getCustomer(666);

        assertEquals(666, result.getCustomerId());
        assertFalse(result.getCustomerName().isEmpty());
    }
}