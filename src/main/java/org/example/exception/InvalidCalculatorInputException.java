package org.example.exception;

public class InvalidCalculatorInputException extends RuntimeException{

    public InvalidCalculatorInputException() {
        super("Invalid parameter(s). Exiting calculator.");
    }

}
