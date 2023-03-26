package pro.sry.homework.calculator.calculatorForTests.Services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    void plus_success() {
        Integer num1 = 10;
        Integer num2 = 15;

        String expectedResult = String.format("%s + %s = %s", num1, num2, num1 + num2);
        String actualResult = calculatorService.plus(num1, num2);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void plus_success2() {
        Integer num1 = 7;
        Integer num2 = 6;

        String expectedResult = String.format("%s + %s = %s", num1, num2, num1 + num2);
        String actualResult = calculatorService.plus(num1, num2);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void minus_success() {
        Integer num1 = 7;
        Integer num2 = 13;

        String expectedResult = String.format("%s - %s = %s", num1, num2, num1 - num2);
        String actualResult = calculatorService.minus(num1, num2);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void minus_success2() {
        Integer num1 = 4;
        Integer num2 = 2;

        String expectedResult = String.format("%s - %s = %s", num1, num2, num1 - num2);
        String actualResult = calculatorService.minus(num1, num2);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void multiply_success() {
        Integer num1 = 8;
        Integer num2 = 6;

        String expectedResult = String.format("%s * %s = %s", num1, num2, num1 * num2);
        String actualResult = calculatorService.multiply(num1, num2);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void multiply_success2() {
        Integer num1 = 12;
        Integer num2 = 8;

        String expectedResult = String.format("%s * %s = %s", num1, num2, num1 * num2);
        String actualResult = calculatorService.multiply(num1, num2);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void divide_success() {
        Integer num1 = 3;
        Integer num2 = 7;
        double result = (double)num1 / (double)num2;

        String expectedResult = String.format("%s : %s = %s", num1, num2, result);
        String actualResult = calculatorService.divide(num1, num2);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    void divide_success2() {
        Integer num1 = 12;
        Integer num2 = 11;
        double result = (double)num1 / (double)num2;

        String expectedResult = String.format("%s : %s = %s", num1, num2, result);
        String actualResult = calculatorService.divide(num1, num2);

        assertEquals(expectedResult,actualResult);
    }
}