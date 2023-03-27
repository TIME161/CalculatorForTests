package pro.sry.homework.calculator.calculatorForTests.services;


import org.springframework.stereotype.Service;
import pro.sry.homework.calculator.calculatorForTests.exceptions.DivideByZeroException;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public String welcome() {
        return "Добро пожаловать в калькулятор!";
    }

    public String plus(int num1, int num2) {
        return String.format("%d + %d = %d", num1, num2, num1 + num2);
    }

    public String minus(int num1, int num2) {
        return String.format("%d - %d = %d", num1, num2, num1 - num2);
    }

    public String multiply(int num1, int num2) {
        return String.format("%d * %s = %s", num1, num2, num1 * num2);
    }

    public String divide(int num1, int num2) {

        if (num2 == 0) {
            throw new DivideByZeroException("Деление на ноль у нас не преветствуется");

        }else {
            double result = (double)num1 / (double)num2;
            return String.format("%d : %d = %f", num1, num2, result);
        }
    }
}