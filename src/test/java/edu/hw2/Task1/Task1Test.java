package edu.hw2.Task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    @DisplayName("Создание Constant(123)")
    public void test1ConstantValue() {
        Expr constant = new Constant(123);
        Assertions.assertThat(constant.evaluate()).isEqualTo(123.0);
    }

    @Test
    @DisplayName("Сложение Constant(2) и Constant(3)")
    public void test2ConstantSum() {
        Expr addition = new Addition(new Constant(2), new Constant(3));
        Assertions.assertThat(addition.evaluate()).isEqualTo(5.0);
    }

    @Test
    @DisplayName("Тест Negate с Constant(100)")
    public void test3NegatePositive() {
        Expr negate = new Negate(new Constant(100));
        Assertions.assertThat(negate.evaluate()).isEqualTo(-100.0);
    }

    @Test
    @DisplayName("Тест Negate с Constant(-100)")
    public void test4NegateNegative() {
        Expr negate = new Negate(new Constant(-100));
        Assertions.assertThat(negate.evaluate()).isEqualTo(100.0);
    }


    @Test
    @DisplayName("Constant(5) * Constant(5)")
    public void test5Multiplication() {
        Expr mult = new Multiplication(new Constant(5), new Constant(5));
        Assertions.assertThat(mult.evaluate()).isEqualTo(25.0);
    }

    @Test
    @DisplayName("Тест Exponent с Constant(5), Constant(3)")
    public void test6ExponentTwoConstants() {
        Expr negate = new Exponent(new Constant(5), new Constant(3));
        Assertions.assertThat(negate.evaluate()).isEqualTo(125.0);
    }

    @Test
    @DisplayName("Тест Exponent с Constant(5), 2")
    public void test7ExponentOneConstant() {
        Expr negate = new Exponent(new Constant(5), 2);
        Assertions.assertThat(negate.evaluate()).isEqualTo(25.0);
    }

    @Test
    @DisplayName("Тест из задания на все выражения")
    public void test8AllExpressions() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));
        Assertions.assertThat(res.evaluate()).isEqualTo(37.0);
    }

    @Test
    @DisplayName("Сложение Constant(2) и 3")
    public void test9OneConstantSum() {
        Expr addition = new Addition(new Constant(2), 3);
        Assertions.assertThat(addition.evaluate()).isEqualTo(5.0);
    }

    @Test
    @DisplayName("Сложение 2 и 3")
    public void test10NumberSum() {
        Expr addition = new Addition(2, 3);
        Assertions.assertThat(addition.evaluate()).isEqualTo(5.0);
    }

    @Test
    @DisplayName("Constant(5) * Constant(5)")
    public void test11MultiplicationOneConstant() {
        Expr mult = new Multiplication(new Constant(5), 5);
        Assertions.assertThat(mult.evaluate()).isEqualTo(25.0);
    }

    @Test
    @DisplayName("Constant(5) * Constant(5)")
    public void test12MultiplicationNumbers() {
        Expr mult = new Multiplication(5, 5);
        Assertions.assertThat(mult.evaluate()).isEqualTo(25.0);
    }
}
