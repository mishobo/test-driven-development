package com.mishobo.test_driven_development;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class MethodOrderedByNameTest {

    @Test
    void testA(){
        System.out.println("testA");
    }

    @Test
    void testD(){
        System.out.println("testD");
    }

    @Test
    void testE(){
        System.out.println("testE");
    }

    @Test
    void testC(){
        System.out.println("testC");
    }

    @Test
    void testB(){
        System.out.println("testB");
    }

    @Test
    void testF(){
        System.out.println("testF");
    }


}

