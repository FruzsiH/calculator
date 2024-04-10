package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.CalculatorFactory;
import org.example.calculator.CalculatorInputKey;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Calculator calculator =  CalculatorFactory.getCalculator(UserInteractionHandler.getCalculatorType());
        Map<CalculatorInputKey, String> input = UserInteractionHandler.getInput();
        calculator.validate(input);
        UserInteractionHandler.printResult(calculator.calculate(input));
    }
}