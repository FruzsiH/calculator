package org.example.calculator;

import org.example.exception.InvalidCalculatorInputException;
import org.example.exception.InvalidCalculatorTypeException;

import java.util.Map;

public class Calculator implements Validator {
    public void validate(Map<CalculatorInputKey, String> input) {

        validateNumber(input.get(CalculatorInputKey.A));
        validateNumber(input.get(CalculatorInputKey.B));
        validateOperator(input.get(CalculatorInputKey.OPERATOR));
    }

    private void validateNumber(String stringNumber) {
        try {
            Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new InvalidCalculatorInputException();
        }
    }

    private static void validateOperator(String operator) {
        if (!operator.equals("+") &&
                !operator.equals("-") &&
                !operator.equals("*") &&
                !operator.equals("/")) {
            if (operator.equals("$") || operator.equals("#")) {
                throw new InvalidCalculatorTypeException();
            }
            throw new InvalidCalculatorInputException();
        }
    }

    public double calculate(Map<CalculatorInputKey, String> input) {
        int a = Integer.parseInt(input.get(CalculatorInputKey.A));
        int b = Integer.parseInt(input.get(CalculatorInputKey.B));
        String operator = input.get(CalculatorInputKey.OPERATOR);

        switch (operator) {
            case "+" -> {
                return a + b;
            }
            case "-" -> {
                return a - b;
            }
            case "*" -> {
                return a * b;
            }
            case "/" -> {
                return (double) a /b;
            }
            default -> throw new RuntimeException("Unexpected error");
        }
    }
}

