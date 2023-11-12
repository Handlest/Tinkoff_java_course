package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.validateAlphabetThird0;
import static edu.hw5.Task7.validateLengthBetween1And3;
import static edu.hw5.Task7.validateStartEqualsEnd;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {

    @Test
    @DisplayName("Third is 0: 010010101010")
    void Test1() {
        String string = "010010101010";

        boolean isGood = validateAlphabetThird0(string);
        assertThat(isGood).isTrue();
    }

    @Test
    @DisplayName("Third is 0: 011010101010")
    void Test2() {
        String string = "011010101010";

        boolean isGood = validateAlphabetThird0(string);
        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Third is 0: 01001sdds01")
    void Test3() {
        String string = "01001sdds01";

        boolean isGood = validateAlphabetThird0(string);
        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Start equals end: 1100101")
    void Test4() {
        String string = "1100101";

        boolean isGood = validateStartEqualsEnd(string);
        assertThat(isGood).isTrue();
    }

    @Test
    @DisplayName("Start equals end: 1100100")
    void Test5() {
        String string = "1100100";

        boolean isGood = validateStartEqualsEnd(string);
        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Start equals end: a100101a")
    void Test6() {
        String string = "a100101a";

        boolean isGood = validateStartEqualsEnd(string);
        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Length between 1 and 3: 010")
    void Test7() {
        String string = "010";

        boolean isGood = validateLengthBetween1And3(string);
        assertThat(isGood).isTrue();
    }

    @Test
    @DisplayName("Length between 1 and 3: 01032")
    void Test8() {
        String string = "01032";

        boolean isGood = validateLengthBetween1And3(string);
        assertThat(isGood).isFalse();
    }

    @Test
    @DisplayName("Length between 1 and 3: a10")
    void Test9() {
        String string = "a10";

        boolean isGood = validateLengthBetween1And3(string);
        assertThat(isGood).isFalse();
    }
}
