package com.mishobo.test_driven_development.orderOfUnitTestsClass;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(2)
public class UserServiceTest {

    @BeforeAll
    static void setup(){
        System.out.println("Test methods related to UserService");
    }


    @Test
    void testCreateUser_whenFirstNameIsMissing_thenThrowUserServiceException() {}


}
