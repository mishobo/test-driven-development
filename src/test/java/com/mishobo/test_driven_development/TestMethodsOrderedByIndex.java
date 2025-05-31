package com.mishobo.test_driven_development;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMethodsOrderedByIndex {

    @Order(1)
    @Test
    void testA(){System.out.println("test 1");}

    @Order(4)
    @Test
    void testD(){
        System.out.println("test 4");
    }

    @Order(3)
    @Test
    void testE(){
        System.out.println("test 3");
    }

    @Order(2)
    @Test
    void testC(){
        System.out.println("test 2");
    }

    @Order(6)
    @Test
    void testB(){
        System.out.println("test 6");
    }

    @Order(5)
    @Test
    void testF(){
        System.out.println("test 5");
    }



}
