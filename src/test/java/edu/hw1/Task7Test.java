package edu.hw1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Right 8, 1")
    void test1() {
        // given
        int n = 8;
        int shift = 1;

        // when
        int afterShift = Task7.rotateRight(n, shift);

        // then
        assertThat(afterShift).isEqualTo(4);
    }

    @Test
    @DisplayName("Left 16, 1")
    void test2() {
        // given
        int n = 16;
        int shift = 1;

        // when
        int afterShift = Task7.rotateLeft(n, shift);

        // then
        assertThat(afterShift).isEqualTo(1);
    }

    @Test
    @DisplayName("Left 16, 1")
    void test3() {
        // given
        int n = 17;
        int shift = 2;

        // when
        int afterShift = Task7.rotateLeft(n, shift);

        // then
        assertThat(afterShift).isEqualTo(6);
    }

    @Test
    @DisplayName("Right 0, 1")
    void test4() {
        // given
        int n = 0;
        int shift = 1;

        // when
        int afterShift = Task7.rotateRight(n, shift);

        // then
        assertThat(afterShift).isEqualTo(0);
    }

    @Test
    @DisplayName("Right 10, 0")
    void test5() {
        // given
        int n = 10;
        int shift = 0;

        // when
        int afterShift = Task7.rotateRight(n, shift);

        // then
        assertThat(afterShift).isEqualTo(10);
    }

    @Test
    @DisplayName("Right 2, Integer.MAX_VALUE")
    void test6() {
        // given
        int n = 2;
        int shift = Integer.MAX_VALUE;

        // when
        int afterShift = Task7.rotateRight(n, shift);

        // then
        assertThat(afterShift).isEqualTo(1);
    }

    @Test
    @DisplayName("Right 8, -1")
    void test7() {
        // given
        int n = 8;
        int shift = -1;

        // when
        int afterShift = Task7.rotateRight(n, shift);

        // then
        assertThat(afterShift).isEqualTo(1);
    }

    @Test
    @DisplayName("Left 8, -1")
    void test8() {
        // given
        int n = 8;
        int shift = -1;

        // when
        int afterShift = Task7.rotateLeft(n, shift);

        // then
        assertThat(afterShift).isEqualTo(4);
    }
}
