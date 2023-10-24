package edu.hw2.task1;

public record Exponent(Expr expression, Expr power) implements Expr {

    public Exponent(Expr expr, double degree) {
        this(expr, new Constant(degree));
    }

    @Override
    public double evaluate() {
        return Math.pow(expression.evaluate(), power.evaluate());
    }
}
