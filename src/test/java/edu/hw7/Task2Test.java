package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static edu.hw7.Task2.countFactorial;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    @Test
    @DisplayName("Факториал 5")
    void test1() {
        int number = 5;

        var result = countFactorial(number);

        // then
        assertThat(result).isEqualTo(new BigInteger(String.valueOf(120)));
    }


    @Test
    @DisplayName("Отрицательное число")
    void test2() {
        int number = -5;

        // then
        assertThrows(IllegalArgumentException.class, () -> countFactorial(number));
    }

    @Test
    @DisplayName("Факториал 25")
    void test3() {
        int number = 25;

        var result = countFactorial(number);

        // then
        assertThat(result.toString()).isEqualTo("15511210043330985984000000");
    }
}
