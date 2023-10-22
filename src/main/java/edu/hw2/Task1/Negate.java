package edu.hw2.Task1;

public record Negate(Constant constant) implements Expr {
    @Override
    public double evaluate() {
        return -constant.evaluate();
    }
}
