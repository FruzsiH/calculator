package org.example.exception;

public class NoSuchCalculatorTypeException extends RuntimeException{

    public NoSuchCalculatorTypeException() {
        super("There is no such calculator type.Exiting calculator.");
    }
}
