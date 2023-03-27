package pro.sry.homework.calculator.calculatorForTests.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sry.homework.calculator.calculatorForTests.exceptions.DivideByZeroException;
import pro.sry.homework.calculator.calculatorForTests.services.CalculatorService;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {
    @Autowired
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DivideByZeroException.class)
    public String handleException(DivideByZeroException e) {
        return String.format("%s", e.getMessage());
    }

    @GetMapping()
    public String welcomeMessege() {
        return calculatorService.welcome();
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return calculatorService.divide(num1, num2);
    }

}
