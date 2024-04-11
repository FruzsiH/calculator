package org.example.calculator;

import java.util.Map;

public interface Validator {
    ValidationResult validate(CalculatorInput input);
}
