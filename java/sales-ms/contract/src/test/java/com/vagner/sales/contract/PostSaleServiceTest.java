package com.vagner.sales.contract;

import com.vagner.sales.contract.post.PostSaleRequest;
import com.vagner.sales.contract.post.PostSaleResponse;
import com.vagner.sales.contract.post.PostSaleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Contract - SalesFace")
class PostSaleServiceTest {

    private PostSaleService service = new PostSaleService();

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