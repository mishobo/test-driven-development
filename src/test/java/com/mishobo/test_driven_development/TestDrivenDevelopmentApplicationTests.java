package com.mishobo.test_driven_development;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("Test math operations in Calculator class")
@SpringBootTest
class TestDrivenDevelopmentApplicationTests {

	//Arrange
	Calculator calculator = new Calculator();

	@Test
	void contextLoads() {
	}

	@DisplayName("Test 4/2")
	@Test
	void testDivide_forValidParameters() {
		//Act
		int result = calculator.divide(4, 2);
		//assert
		assertEquals(2, result);
	}

	@DisplayName("Test 10-5")
	@Test
	void testIntegerSubtraction() {
		int result = calculator.integerSubtraction(10, 5);
		assertEquals(5, result);
	}


	@DisplayName("Test 4/0")
	@Test
	void testDivide_When4isDividedByO_ThrowArithmeticException() {
		String expectedExceptionMessage = "/ by zero";


		ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
			calculator.divide(4, 0);
		}, "Expected ArithmeticException to be thrown");

		System.out.println(actualException.getMessage());

		assertEquals(expectedExceptionMessage, actualException.getMessage());
	}

}
