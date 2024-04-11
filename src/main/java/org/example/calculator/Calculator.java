package org.example.calculator;

import org.example.exception.InvalidCalculatorInputException;
import org.example.exception.InvalidCalculatorTypeException;
import org.example.operator.*;

import java.util.HashMap;
import java.util.Map;

public class Calculator implements Validator {
    protected Map <String, Operator> operatorMap = new HashMap<>();
    public Calculator() {
        operatorMap.put("+", new Addition());
        operatorMap.put("-", new Substraction());
        operatorMap.put("/", new Division());
        operatorMap.put("*", new Multiplication());
    }

    @Override
    public ValidationResult validate(CalculatorInput input) {
        if (!operatorMap.containsKey(input.getOperator())) {
            if (input.getOperator().equals("$") || input.getOperator().equals("#")) {
                return ValidationResult.INVALID_TYPE;
            }
            return ValidationResult.INVALID_INPUT;
        }
        return ValidationResult.OK;
    }


    private void validateNumber(String stringNumber) {
        try {
            Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new InvalidCalculatorInputException();
        }
    }

    public double calculate(CalculatorInput input) {
       return operatorMap.get(input.getOperator()).execute(input.getA(), input.getB());
    }
}