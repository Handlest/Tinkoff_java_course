package edu.hw1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("[1, 2, 3, 4], [0, 6]")
    void test1() {
        // given
        int[] firstArr = { 1, 2, 3, 4 };
        int[] secondArr = { 0, 6 };

        // when
        boolean isNestable = Task3.isNestable(firstArr, secondArr);

        // then
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("[3, 1], [4, 0]")
    void test2()  {
        // given
        int[] firstArr = { 3, 1 };
        int[] secondArr = { 4, 0 };

        // when
        boolean isNestable = Task3.isNestable(firstArr, secondArr);

        // then
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("[9, 9, 8], [8, 9]")
    void test3(){
        // given
        int[] firstArr = { 9, 9, 8 };
        int[] secondArr = { 8, 9 };

        // when
        boolean isNestable = Task3.isNestable(firstArr, secondArr);

        // then
        assertThat(isNestable).isEqualTo(false);
    }

    @Test
    @DisplayName("[1, 2, 3, 4], [2, 3]")
    void test4() {
        // given
        int[] firstArr = { 1, 2, 3, 4 };
        int[] secondArr = { 2, 3 };

        // when
        boolean isNestable = Task3.isNestable(firstArr, secondArr);

        // then
        assertThat(isNestable).isEqualTo(false);
    }

    @Test
    @DisplayName("[], [2, 3]")
    void test5() {
        // given
        int[] firstArr = { };
        int[] secondArr = { 2, 3 };
        boolean isNestable = Task3.isNestable(firstArr, secondArr);

        // then
        assertThat(isNestable).isEqualTo(true);
    }


    @Test
    @DisplayName("[1, 2, 3, 4], []")
    void test6() {
        // given
        int[] firstArr = { 1, 2, 3, 4 };
        int[] secondArr = { };

        // when
        boolean isNestable = Task3.isNestable(firstArr, secondArr);

        // then
        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("[], []")
    void test7() {
        // given
        int[] firstArr = { };
        int[] secondArr = { };

        // when
        boolean isNestable = Task3.isNestable(firstArr, secondArr);

        // then
        assertThat(isNestable).isEqualTo(true);
    }
}
