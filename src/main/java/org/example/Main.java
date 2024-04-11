package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.CalculatorFactory;
import org.example.calculator.CalculatorInput;
import org.example.calculator.ValidationResult;

public class Main {
    public static void main(String[] args) {
        Calculator calculator =  CalculatorFactory.getCalculator(UserInteractionHandler.getCalculatorType());
        CalculatorInput input = UserInteractionHandler.getInput();
        UserInteractionHandler.handlerValidationResult(calculator.validate(input));
        UserInteractionHandler.printResult(calculator.calculate(input));
    }
}