package pro.sry.homework.calculator.calculatorForTests.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sry.homework.calculator.calculatorForTests.exceptions.DivideByZeroException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {CalculatorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalculatorServiceImplTest {

    private static Stream<Arguments> nums() {
        return Stream.of(
                Arguments.of(2, 9),
                Arguments.of(7, 13),
                Arguments.of(4, 6)
        );
    }

    private static Stream<Arguments> numsForDivideByZero() {
        return Stream.of(
                Arguments.of(2, 0),
                Arguments.of(7, 0),
                Arguments.of(4, 0)
        );
    }

    @Autowired
    private CalculatorService calculatorService;

    @ParameterizedTest(name = "{index} => num1={0}, num2={1}")
    @MethodSource("nums")
    void plus_success(int num1, int num2) {
        String expectedResult = String.format("%d + %d = %d", num1, num2, num1 + num2);
        String actualResult = calculatorService.plus(num1, num2);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{index} => num1={0}, num2={1}")
    @MethodSource("nums")
    void minus_success(int num1, int num2) {
        String expectedResult = String.format("%d - %d = %d", num1, num2, num1 - num2);
        String actualResult = calculatorService.minus(num1, num2);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{index} => num1={0}, num2={1}")
    @MethodSource("nums")
    void multiply_success(int num1, int num2) {
        String expectedResult = String.format("%d * %d = %d", num1, num2, num1 * num2);
        String actualResult = calculatorService.multiply(num1, num2);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{index} => num1={0}, num2={1}")
    @MethodSource("nums")
    void divide_success(int num1, int num2) {
        double result = (double) num1 / (double) num2;

        String expectedResult = String.format("%d : %d = %f", num1, num2, result);
        String actualResult = calculatorService.divide(num1, num2);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "{index} => num1={0}, num2={1}")
    @MethodSource("numsForDivideByZero")
    void divide_withException(int num1, int num2) {
        Exception exception = assertThrows(DivideByZeroException.class, () -> calculatorService.divide(num1,num2));
        String expectedMessege = "Деление на ноль у нас не преветствуется";
        assertEquals(expectedMessege,exception.getMessage());
    }
}