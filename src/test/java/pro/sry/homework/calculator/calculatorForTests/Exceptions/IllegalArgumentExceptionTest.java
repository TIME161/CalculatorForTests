package pro.sry.homework.calculator.calculatorForTests.Exceptions;

import org.junit.jupiter.api.Test;
import pro.sry.homework.calculator.calculatorForTests.Services.CalculatorService;

import static org.junit.jupiter.api.Assertions.*;

class IllegalArgumentExceptionTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    void devide_byZero() {
        Integer num1 = 542;
        Integer num2 = 0;
        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> calculatorService.divide(num1, num2)
        );
        String expectedMessege = "Деление на ноль у нас не преветствуется";
        assertEquals(expectedMessege, exception.getMessage());
    }


}