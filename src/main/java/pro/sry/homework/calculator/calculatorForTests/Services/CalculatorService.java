package pro.sry.homework.calculator.calculatorForTests.Services;

import pro.sry.homework.calculator.calculatorForTests.Exceptions.IllegalArgumentException;

public class CalculatorService {
    public String welcome() {
        return "Добро пожаловать в калькулятор!";
    }

    public String plus(Integer num1, Integer num2) {
        return String.format("%s + %s = %s", num1, num2, num1 + num2);
    }

    public String minus(Integer num1, Integer num2) {
        return String.format("%s - %s = %s", num1, num2, num1 - num2);
    }

    public String multiply(Integer num1, Integer num2) {
        return String.format("%s * %s = %s", num1, num2, num1 * num2);
    }

    public String divide(Integer num1, Integer num2) {

        if (num2 == 0) {
            throw new IllegalArgumentException("Деление на ноль у нас не преветствуется");

        }else {
            double result = (double)num1 / (double)num2;
            return String.format("%s : %s = %s", num1, num2, result);
        }
    }
}
