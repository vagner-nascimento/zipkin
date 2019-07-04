package com.vagner.sales.contract.facade;

import com.vagner.sales.contract.model.response.PostSaleResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.vagner.sales.contract.model.request.PostSale;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Contract - SalesFace")
class SaleFacadeTest {

    private SaleFacade facade = new SaleFacade();

    @Test
    @DisplayName("Whe sent null should return any long")
    public void doSale_WhenSendsNull_ShouldReturnLong() {

        var result = facade.doSale(null);

        assertNotNull(result);
        assertEquals(PostSaleResponse.class, result.getClass());
    }

    @Test
    @DisplayName("Whe sent any data should return any long")
    public void doSale_WhenSendsAnyData_ShouldReturnLong() {

        var result = facade.doSale(new PostSale());

        assertNotNull(result);
        assertEquals(PostSaleResponse.class, result.getClass());
    }
}