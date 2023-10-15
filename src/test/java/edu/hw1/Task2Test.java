package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Заданное число: 4666")
    void test1() {
        // given
        int number = 4666;

        // when
        int digits = Task2.countDigits(number);

        // then
        assertThat(digits).isEqualTo(4);
    }
    @Test
    @DisplayName("Заданное число: 544")
    void test2() {
        // given
        int number = 544;

        // when
        int digits = Task2.countDigits(number);

        // then
        assertThat(digits).isEqualTo(3);
    }
    @Test
    @DisplayName("Заданное число: 0")
    void test3() {
        // given
        int number = 0;

        // when
        int digits = Task2.countDigits(number);

        // then
        assertThat(digits).isEqualTo(1);
    }

    @Test
    @DisplayName("Заданное число: 0000")
    void test4() {
        // given
        int number = 0000;  // При преобразовании незначащие нули отбрасываются

        // when
        int digits = Task2.countDigits(number);

        // then
        assertThat(digits).isEqualTo(1);
    }

    @Test
    @DisplayName("Заданное число: 1234567890")
    void test5() {
        // given
        int number = 1234567890;

        // when
        int digits = Task2.countDigits(number);

        // then
        assertThat(digits).isEqualTo(10);
    }
}
