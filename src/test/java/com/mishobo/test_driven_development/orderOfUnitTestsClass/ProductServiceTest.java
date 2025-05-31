package com.mishobo.test_driven_development.orderOfUnitTestsClass;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(1)
public class ProductServiceTest {

    @BeforeAll
    static void setup(){
        System.out.println("Test methods related to ProductService");
    }


    @Test
    void testCreateProduct_whenProductTitleIsMissing_thenThrowProductServiceException() {}


}
