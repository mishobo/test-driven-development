package com.mishobo.test_driven_development;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("Test math operations in Calculator class")
@SpringBootTest
class TestDrivenDevelopmentApplicationTests {
	//Arrange/Given
	Calculator calculator = new Calculator();

	@Test
	void contextLoads() {
	}

	@DisplayName("Test 4/2")
	@Test
	void testDivide_forValidParameters() {
		//Act/when
		int result = calculator.divide(4, 2);
		//assert/then
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


	@DisplayName("Test integer subtraction [dividend, divisor, expected]")
	@ParameterizedTest
	@MethodSource("integerSubtractionInputParameters")
	void  testIntegerSubtraction (int minuend, int subtrahend, int expected) {
		System.out.println(minuend + " - " + subtrahend + " = " + expected);
		int result = calculator.integerSubtraction(minuend, subtrahend);
		assertEquals(expected, result);
	}

	private static Stream<Arguments> integerSubtractionInputParameters() {
		return Stream.of(
				Arguments.of(33, 1, 32),
				Arguments.of(54, 8, 46),
				Arguments.of(86, 10, 76)
		);
	}


	@DisplayName("integer subtraction csv parameterized")
	@ParameterizedTest
	@CsvSource({"100, 32, 68", "71, 32, 39", "45, 14, 31"})
	void testIntegerSubtraction_WhenCsvParameterized(int minuend, int subtrahend, int expected) {
		System.out.println(minuend + " - " + subtrahend + " = " + expected);
		int result = calculator.integerSubtraction(minuend, subtrahend);
		assertEquals(expected, result);
	}


	@DisplayName("integer subtraction from csv file")
	@ParameterizedTest
	@CsvFileSource(resources = "/integerSubtraction.csv")
	void testIntegerSubtraction_WhenCsvProvided (int minuend, int subtrahend, int expected) {
		System.out.println(minuend + " - " + subtrahend + " = " + expected);
		int result = calculator.integerSubtraction(minuend, subtrahend);
		assertEquals(expected, result);
	}


}
