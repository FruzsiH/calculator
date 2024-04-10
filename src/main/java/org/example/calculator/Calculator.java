package org.example;

import java.util.Map;

public class Calculator implements Validator {
    public void validate(Map<CalculatorInputValue, String> input) {

        validateOperator(input.get(CalculatorInputValue.OPERATOR));
        validateNumber(input.get(CalculatorInputValue.A));
        validateNumber(input.get(CalculatorInputValue.B));
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
            if (operator.equals("$") || !operator.equals("#")) {
                throw new InvalidCalculatorTypeException();
            }
            throw new InvalidCalculatorInputException();
        }
    }
}
