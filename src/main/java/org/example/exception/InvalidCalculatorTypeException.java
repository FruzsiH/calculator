package org.example.exception;

public class InvalidCalculatorTypeException extends RuntimeException {
    public InvalidCalculatorTypeException() {
        super("The given operation is not possible.Exiting calculator");
    }
}
