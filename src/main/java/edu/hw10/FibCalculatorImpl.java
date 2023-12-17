package edu.hw10;

public class FibCalculatorImpl implements FibCalculator {
    public long fib(int number) {
        if (number <= 1) {
            return number;
        }
        return fib(number - 1) + fib(number - 2);
    }
}
