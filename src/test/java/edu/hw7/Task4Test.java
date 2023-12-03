package edu.hw7;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw7.MonteCarloPi.countPi;

public class Task4Test {
    @Test
    @DisplayName("Вычисление числа pi")
    void test1() {
        countPi();
    }
}
