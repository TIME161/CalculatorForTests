package pro.sry.homework.calculator.calculatorForTests.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sry.homework.calculator.calculatorForTests.Exceptions.IllegalArgumentException;
import pro.sry.homework.calculator.calculatorForTests.Services.CalculatorService;

@RestController

@RequestMapping("/calculator")

public class CalculatorController {
    CalculatorService calculatorService = new CalculatorService();

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(IllegalArgumentException e) {
        return String.format("%s", e.getMessage());
    }

    @GetMapping()
    public String welcomeMessege() {
        return calculatorService.welcome();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return calculatorService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return calculatorService.divide(num1, num2);
    }

}
