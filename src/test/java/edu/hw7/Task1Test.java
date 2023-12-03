package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.Task1.twoThreadsOneCounter;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Проверка корректного вычисления с двух потоков")
    void test1() {
        int result = twoThreadsOneCounter();

        // then
        assertThat(result).isEqualTo(1000);
    }
}
