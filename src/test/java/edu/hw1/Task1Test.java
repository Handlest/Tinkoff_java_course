package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Заданное время: 00:00")
    void test1() {
        // given
        String duration = "00:00";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(0);
    }

    @Test
    @DisplayName("Заданное время: 00:10")
    void test2() {
        // given
        String duration = "00:10";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(10);
    }

    @Test
    @DisplayName("Заданное время: 00:59")
    void test3() {
        // given
        String duration = "00:59";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(59);
    }

    @Test
    @DisplayName("Seconds > 59: 00:60")
    void test4() {
        // given
        String duration = "00:60";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Заданное время: 30:00")
    void test5() {
        // given
        String duration = "30:00";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(1800);
    }

    @Test
    @DisplayName("Заданное время: 12:45")
    void test6() {
        // given
        String duration = "12:45";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(765);
    }

    @Test
    @DisplayName("Заданное время: 00:01")
    void test7() {
        // given
        String duration = "00:01";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(1);
    }

    @Test
    @DisplayName("Заданное время: 9999:59")
    void test8() {
        // given
        String duration = "9999:59";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(599999);
    }

    @Test
    @DisplayName("Заданное время: 01:00")
    void test9() {
        // given
        String duration = "01:00";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(60);
    }

    @Test
    @DisplayName("String literal in minutes: aa:00")
    void test10() {
        // given
        String duration = "aa:00";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(-1);
    }
    @Test
    @DisplayName("String literal in seconds: 01:0b")
    void test11() {
        // given
        String duration = "01:0b";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(-1);
    }

    @Test
    @DisplayName("Mismatch format: 01:000")
    void test12() {
        // given
        String duration = "01:000";

        // when
        int seconds = Task1.minutesToSeconds(duration);

        // then
        assertThat(seconds).isEqualTo(-1);
    }
}
