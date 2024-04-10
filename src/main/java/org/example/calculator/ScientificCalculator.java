package org.example.calculator;

import org.example.exception.InvalidCalculatorTypeException;

import java.util.Map;

public class ScientificCalculator extends Calculator {
    @Override
    public void validate(Map<CalculatorInputKey, String> input) {
        try {
            super.validate(input);
        } catch (InvalidCalculatorTypeException ignored) {
        }
    }

    @Override
    public double calculate(Map<CalculatorInputKey, String> input) {
        int a = Integer.parseInt(input.get(CalculatorInputKey.A));
        int b = Integer.parseInt(input.get(CalculatorInputKey.B));
        String operator = input.get(CalculatorInputKey.OPERATOR);

        switch (operator) {
            case "$" -> {
                return Math.pow(a, b);
                }
            case "#" -> {
                return Math.pow(a, (double) 1 /b);
            }
            default -> {
                return super.calculate(input);
            }
        }
    }
}
