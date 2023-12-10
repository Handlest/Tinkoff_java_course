package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static edu.hw5.Task2.getAllFridays13;
import static edu.hw5.Task2.getClosestFriday13;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Тест из текста задачи")
    void Test1() {
        int year = 1925;

        var fridays13s = getAllFridays13(year);

        assertThat(fridays13s).asList().containsExactly("1925-02-13", "1925-03-13", "1925-11-13");
    }

    @Test
    @DisplayName("Тест из текста задачи 2")
    void Test2() {
        int year = 2024;

        var fridays13s = getAllFridays13(year);

        assertThat(fridays13s).asList().containsExactly("2024-09-13", "2024-12-13");
    }

    @Test
    @DisplayName("Ближайшая пятница 13 к дате")
    void Test3() {
        LocalDate date = LocalDate.of(2024, 8, 1);

        var closestFriday13 = getClosestFriday13(date);

        assertThat(closestFriday13).isEqualTo("2024-09-13");
    }
}
