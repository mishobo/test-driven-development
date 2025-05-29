package com.mishobo.test_driven_development;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class TestDrivenDevelopmentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testDivide_forValidParameters() {
		//Arrange
		Calculator calculator = new Calculator();
		//Act
		int result = calculator.divide(4, 2);
		//assert
		assertEquals(2, result);
	}

}
