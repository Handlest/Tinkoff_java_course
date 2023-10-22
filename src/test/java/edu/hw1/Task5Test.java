package edu.hw1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("11211230")
    void test1() {
        // given
        int num = 11211230;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("13001120")
    void test2() {
        // given
        int num = 13001120;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("23336014")
    void test3() {
        // given
        int num = 23336014;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("11")
    void test4() {
        // given
        int num = 11;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("123")
    void test5() {
        // given
        int num = 123;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(false);
    }

    @Test
    @DisplayName("1")
    void test6() {
        // given
        int num = 1;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("10101")
    void test7() {
        // given
        int num = 10101;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("-101") // Отрицательные числа не являются палиндромами из-за знака
    void test8() {
        // given
        int num = -101;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(false);
    }

    @Test
    @DisplayName("Integer.MAX_VALUE")
    void test9() {
        // given
        int num = Integer.MAX_VALUE;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(false);
    }

    @Test
    @DisplayName("0")
    void test10() {
        // given
        int num = 0;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(true);
    }

    @Test
    @DisplayName("Integer.MIN_VALUE")
    void test11() {
        // given
        int num = Integer.MIN_VALUE;

        // when
        boolean isPalindrome = Task5.isPalindromeDescendant(num);

        // then
        assertThat(isPalindrome).isEqualTo(false);
    }
}
