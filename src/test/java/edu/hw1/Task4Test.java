package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("123456")
    void test1() {
        // given
        String str = "123456";

        // when
        String string = Task4.fixString(str);

        // then
        assertThat(string).isEqualTo("214365");
    }

    @Test
    @DisplayName("hTsii  s aimex dpus rtni.g")
    void test2() {
        // given
        String str = "hTsii  s aimex dpus rtni.g";

        // when
        String string = Task4.fixString(str);

        // then
        assertThat(string).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("badce")
    void test3() {
        // given
        String str = "badce";

        // when
        String string = Task4.fixString(str);

        // then
        assertThat(string).isEqualTo("abcde");
    }

    @Test
    @DisplayName("Empty string")
    void test4() {
        // given
        String str = "";

        // when
        String string = Task4.fixString(str);

        // then
        assertThat(string).isEqualTo("");
    }

    @Test
    @DisplayName("a")
    void test5() {
        // given
        String str = "a";

        // when
        String string = Task4.fixString(str);

        // then
        assertThat(string).isEqualTo("a");
    }

    @Test
    @DisplayName("ab")
    void test6() {
        // given
        String str = "ab";

        // when
        String string = Task4.fixString(str);

        // then
        assertThat(string).isEqualTo("ba");
    }
}
