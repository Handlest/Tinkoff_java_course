package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task8.validate0multiple3;
import static edu.hw5.Task8.validateAnyExcept11And111;
import static edu.hw5.Task8.validateHasUnevenLength;
import static edu.hw5.Task8.validateNoSequential1;
import static edu.hw5.Task8.validateStarts0UnevenOrStarts1Even;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {

    @Test
    @DisplayName("Uneven length: 1010101")
    void Test1() {
        String string = "1010101";

        boolean isGood = validateHasUnevenLength(string);

        assertThat(isGood).isTrue();
    }

    @Test
    @DisplayName("Uneven length: 101010")
    void Test2() {
        String string = "101010";

        boolean isGood = validateHasUnevenLength(string);

        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Uneven length: 1010101a")
    void Test3() {
        String string = "1010101a";

        boolean isGood = validateHasUnevenLength(string);

        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Uneven if starts with 0; even if starts with 1: 00101; 101010")
    void Test4() {
        String string1 = "00101";
        String string2 = "101010";

        boolean isGood = validateStarts0UnevenOrStarts1Even(string1);

        assertThat(isGood).isTrue();
        isGood = validateStarts0UnevenOrStarts1Even(string2);
        assertThat(isGood).isTrue();
    }

    @Test
    @DisplayName("Uneven if starts with 0; even if starts with 1: 10101; 001010")
    void Test5() {
        String string1 = "10101";
        String string2 = "001010";

        boolean isGood = validateStarts0UnevenOrStarts1Even(string1);

        assertThat(isGood).isFalse();
        isGood = validateStarts0UnevenOrStarts1Even(string2);
        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Amount of 0 is multiple of 3: 101010")
    void Test6() {
        String string = "101010";

        boolean isGood = validateStarts0UnevenOrStarts1Even(string);

        assertThat(isGood).isTrue();
    }

    @Test
    @DisplayName("Amount of 0 is multiple of 3: 101010")
    void Test7() {
        String string = "101010";

        boolean isGood = validate0multiple3(string);

        assertThat(isGood).isTrue();
    }

    @Test
    @DisplayName("Amount of 0 is multiple of 3: 10101")
    void Test8() {
        String string = "10101";

        boolean isGood = validate0multiple3(string);

        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Amount of 0 is multiple of 3: 111")
    void Test9() {
        String string = "111";

        boolean isGood = validate0multiple3(string);

        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Amount of 0 is multiple of 3: 111")
    void Test10() {
        String string = "111";

        boolean isGood = validate0multiple3(string);

        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Validate any except for 11 and 111: 111")
    void Test11() {
        String string = "111";

        boolean isGood = validateAnyExcept11And111(string);

        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Validate any except for 11 and 111: 11")
    void Test12() {
        String string = "11";

        boolean isGood = validateAnyExcept11And111(string);

        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Validate any except for 11 and 111: 110111")
    void Test13() {
        String string = "110111";

        boolean isGood = validateAnyExcept11And111(string);

        assertThat(isGood).isTrue();
    }

    @Test
    @DisplayName("Validate no repeating 1: 110111")
    void Test14() {
        String string = "110111";

        boolean isGood = validateNoSequential1(string);

        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Validate no repeating 1: 0001010101010")
    void Test15() {
        String string = "0001010101010";

        boolean isGood = validateNoSequential1(string);

        assertThat(isGood).isTrue();
    }

    @Test
    @DisplayName("Validate no repeating 1: 0001010101010a1")
    void Test16() {
        String string = "a0001010101010a1";

        boolean isGood = validateNoSequential1(string);

        assertThat(isGood).isFalse();
    }
}
