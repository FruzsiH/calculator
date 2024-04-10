package org.example.calculator;

import java.util.Map;

public interface Validator {
    void validate(Map<CalculatorInputKey, String> input);
}
