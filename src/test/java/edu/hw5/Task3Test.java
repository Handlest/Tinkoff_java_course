package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.Task3.parseDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("2302-01-01")
    void Test1() {
        String dateString = "2302-01-01";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(2302, 1, 1)));
    }

    @Test
    @DisplayName("99999-01-01")
    void Test2() {
        String dateString = "99999-01-01";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(99999, 1, 1)));
    }

    @Test
    @DisplayName("99999-1-1")
    void Test3() {
        String dateString = "99999-1-1";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(99999, 1, 1)));
    }

    @Test
    @DisplayName("1/1/2023")
    void Test4() {
        String dateString = "1/1/2023";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(2023, 1, 1)));
    }

    @Test
    @DisplayName("01/01/2023")
    void Test5() {
        String dateString = "01/01/2023";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(2023, 1, 1)));
    }

    @Test
    @DisplayName("tomorrow")
    void Test6() {
        String dateString = "tomorrow";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(2023, 12, 9)));
    }

    @Test
    @DisplayName("today")
    void Test7() {
        String dateString = "today";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(2023, 12, 8)));
    }

    @Test
    @DisplayName("yesterday")
    void Test8() {
        String dateString = "yesterday";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(2023, 12, 7)));
    }

    @Test
    @DisplayName("2234 days ago")
    void Test9() {
        String dateString = "2234 days ago";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(2017, 10, 26)));
    }

    @Test
    @DisplayName("1 day ago")
    void Test10() {
        String dateString = "1 day ago";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(2023, 12, 7)));
    }

    @Test
    @DisplayName("Wrong string")
    void Test11() {
        String dateString = "Hello what a good day";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("1/3/20")
    void Test12() {
        String dateString = "1/3/20";

        var dateParsed = parseDate(dateString);

        assertThat(dateParsed).isEqualTo(Optional.of(LocalDate.of(20, 3, 1)));
    }
}
