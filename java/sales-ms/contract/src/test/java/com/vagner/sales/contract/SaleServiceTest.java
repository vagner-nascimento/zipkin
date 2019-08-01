package com.vagner.sales.contract;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Contract - SalesFace")
class SaleServiceTest {

    private SaleService service = new SaleService();

    @Test
    @DisplayName("Whe sent null should return any long")
    public void doSale_WhenSendsNull_ShouldReturnLong() {

        var result = service.doSale(null);

        assertNotNull(result);
        assertEquals(PostSaleResponse.class, result.getClass());
    }

    @Test
    @DisplayName("Whe sent any data should return any long")
    public void doSale_WhenSendsAnyData_ShouldReturnLong() {

        var result = service.doSale(new PostSaleRequest());

        assertNotNull(result);
        assertEquals(PostSaleResponse.class, result.getClass());
    }
}