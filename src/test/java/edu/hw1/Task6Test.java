package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task6Test {
    @Test
    @DisplayName("3524")
    void test1() {
        // given
        int num = 3524;

        // when
        int Kaprekar = Task6.countK(num);

        // then
        assertThat(Kaprekar).isEqualTo(3);
    }

    @Test
    @DisplayName("6621")
    void test2() {
        // given
        int num = 6621;

        // when
        int Kaprekar = Task6.countK(num);

        // then
        assertThat(Kaprekar).isEqualTo(5);
    }

    @Test
    @DisplayName("6554")
    void test3() {
        // given
        int num = 6554;

        // when
        int Kaprekar = Task6.countK(num);

        // then
        assertThat(Kaprekar).isEqualTo(4);
    }

    @Test
    @DisplayName("1234")
    void test4() {
        // given
        int num = 1234;

        // when
        int Kaprekar = Task6.countK(num);

        // then
        assertThat(Kaprekar).isEqualTo(3);
    }

    @Test
    @DisplayName("0")
    void test5() {
        // when given
        int num = 0;

        // then
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(num));
    }

    @Test
    @DisplayName("10000")
    void test6() {
        // when given
        int num = 10000;

        // then
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(num));
    }

    @Test
    @DisplayName("6174")
    void test7() {
        // given
        int num = 6174;

        // when
        int Kaprekar = Task6.countK(num);

        // then
        assertThat(Kaprekar).isEqualTo(0);
    }

    @Test
    @DisplayName("Integer.MIN_VALUE")
    void test8() {
        // when given
        int num = Integer.MIN_VALUE;

        // then
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(num));
    }

    @Test
    @DisplayName("Integer.MAX_VALUE")
    void test9() {
        // when given
        int num = Integer.MAX_VALUE;

        // then
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(num));
    }

    @Test
    @DisplayName("9998")
    void test10() {
        // given
        int num = 9998;

        // when
        int Kaprekar = Task6.countK(num);

        // then
        assertThat(Kaprekar).isEqualTo(5);
    }

    @Test
    @DisplayName("1001")
    void test11() {
        // given
        int num = 1001;

        // when
        int Kaprekar = Task6.countK(num);

        // then
        assertThat(Kaprekar).isEqualTo(4);
    }
}
