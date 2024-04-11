package org.example;

import org.example.calculator.CalculatorInput;
import org.example.calculator.CalculatorType;
import org.example.calculator.ValidationResult;
import org.example.exception.InvalidCalculatorInputException;
import org.example.exception.InvalidCalculatorTypeException;
import org.example.exception.NoSuchCalculatorTypeException;

import java.util.Scanner;

public class UserInteractionHandler {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static CalculatorType getCalculatorType() {
        System.out.println("Adja meg milyen kalkulátort szeretne használni. calculator egyszerűsített számológép, vagy scientific tudományos számológép");
        System.out.println("Az egyszerű összeadni, kivonni, szorozni, osztani tud");
        System.out.println("A tudományos hatványozni és gyököt vonni.");

        try {
            return CalculatorType.valueOf(SCANNER.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new NoSuchCalculatorTypeException();
        }
    }

    public static CalculatorInput getInput() {
        System.out.println("Adja meg a számokat és a műveletet.");
        System.out.println("Először egy számot, majd a műveletet, majd még egy számot adjon meg");
        System.out.println("Az operátorok a következők:");
        System.out.println("Összeadás: +");
        System.out.println("Kivonás: -");
        System.out.println("Szorzás: *");
        System.out.println("Osztás: /");
        System.out.println("Hatványozás, ahol a második szám a kitevő: &");
        System.out.println("Gyökvonás, ahol a második szám jelzo, hogy hanyadik gyök: #");

        CalculatorInput input = new CalculatorInput();
        input.setA(SCANNER.next());
        input.setOperator(SCANNER.next());
        input.setB(SCANNER.next());
        return input;
    }

    public static void printResult(double result) {
        System.out.printf("Az eredmény: %s", result);
    }

    public static void handlerValidationResult(ValidationResult validationResult) {
        switch (validationResult) {
            case INVALID_INPUT -> throw new InvalidCalculatorInputException();
            case INVALID_TYPE -> throw new InvalidCalculatorTypeException();
            case OK -> {
            }
            default -> throw new RuntimeException("Unexpected error");
        }
    }
}
