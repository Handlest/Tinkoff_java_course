package edu.hw2.task1;

public record Multiplication(Expr firstExpression, Expr secondExpression) implements Expr {

    public Multiplication(Expr expr, double number) {
        this(expr, new Constant(number));
    }

    public Multiplication(double firstNumber, double secondNumber) {
        this(new Constant(firstNumber), new Constant(secondNumber));
    }

    @Override
    public double evaluate() {
        return firstExpression.evaluate() * secondExpression.evaluate();
    }
}
