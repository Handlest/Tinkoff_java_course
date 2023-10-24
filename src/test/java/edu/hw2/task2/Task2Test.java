package edu.hw2.task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(5, 20)),
            Arguments.of(new Square(10)),
            Arguments.of(new Square(0)),
            Arguments.of(new Rectangle()),
            Arguments.of(new Rectangle())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(2);
        rect = rect.setHeight(50);

        assertThat(rect.area()).isEqualTo(100.0);
    }

    @Test
    @DisplayName("Проверка создания квадрата")
    public void createSquare() {
        Square square = new Square(5);
        assertThat(square).extracting("side").isEqualTo(5);
    }

    @Test
    @DisplayName("Проверка создания квадрата через прямоугольник")
    public void createSquareAsRectangle() {
        Rectangle square = new Square(5);
        assertThat(square.area()).isEqualTo(25.0);
    }

    @Test
    @DisplayName("Изменение стороны квадрата")
    public void changeSquareSide() {
        Square square = new Square(5);
        square = square.setSides(2);
        assertThat(square.area()).isEqualTo(4.0);
    }

    @Test
    @DisplayName("Проверка создания прямоугольника и значений его полей")
    public void rectangleCreation() {
        Rectangle rectangle = new Rectangle(5, 10);
        assertThat(rectangle).extracting("width", "height").containsExactly(5, 10);
    }
}
