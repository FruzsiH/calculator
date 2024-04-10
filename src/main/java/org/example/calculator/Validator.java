package org.example;

import java.util.Map;

public interface Validator {
    void validate(Map<CalculatorInputValue, String> input);
}
