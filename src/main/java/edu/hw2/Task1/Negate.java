package edu.hw2.Task1;

public record Negate(Expr expression) implements Expr {
    @Override
    public double evaluate() {
        return -expression.evaluate();
    }
}
