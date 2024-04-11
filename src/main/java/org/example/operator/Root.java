package org.example.operator;

public class Root implements Operator {
    @Override
    public double execute(int a, int b) {
        return Math.pow(a, (double) 1/b);
    }
}
