package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task1.getAnalytics;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Тест из текста задачи")
    void Test1() {
        String input =  "2022-03-12, 20:20 - 2022-03-12, 23:50\n" +
                        "2022-04-01, 21:30 - 2022-04-02, 01:20";

        String averageTime = getAnalytics(input);

        assertThat(averageTime).isEqualTo("3ч 40м");
    }
}
