package edu.hw2.Task1;

public record Addition(Expr firstExpression, Expr secondExpression) implements Expr {
    public Addition(Expr expr, double number) {
        this(expr, new Constant(number));
    }

    public Addition(double firstNumber, double secondNumber) {
        this(new Constant(firstNumber), new Constant(secondNumber));
    }

    @Override
    public double evaluate() {
        return firstExpression.evaluate() + secondExpression.evaluate();
    }
}
