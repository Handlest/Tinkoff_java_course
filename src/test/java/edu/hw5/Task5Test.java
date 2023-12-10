package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task5.validateCarNumber;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Right number examples from task")
    void Test1() {
        String carNumber1 = "А123ВЕ777";
        String carNumber2 = "О777ОО177";

        boolean isValid = validateCarNumber(carNumber1);
        assertThat(isValid).isTrue();
        isValid = validateCarNumber(carNumber2);
        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("Wrong number examples from task")
    void Test2() {
        String carNumber1 = "123АВЕ777";
        String carNumber2 = "А123ВГ77";
        String carNumber3 = "А123ВЕ7777";

        boolean isValid = validateCarNumber(carNumber1);
        assertThat(isValid).isFalse();
        isValid = validateCarNumber(carNumber2);
        assertThat(isValid).isFalse();
        isValid = validateCarNumber(carNumber3);
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Right numbers with two digit region")
    void Test3() {
        String carNumber1 = "А123ВЕ03";
        String carNumber2 = "О777ОО99";

        boolean isValid = validateCarNumber(carNumber1);
        assertThat(isValid).isTrue();
        isValid = validateCarNumber(carNumber2);
        assertThat(isValid).isTrue();
    }
}
