package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {
    @Test
    @DisplayName("2 -> II")
    public void test1() {

        int inputNumber = 2;

        String romanStringNumber = Task4.convertToRoman(inputNumber);

        Assertions.assertThat(romanStringNumber).isEqualTo("II");
    }

    @Test
    @DisplayName("12 -> XII")
    public void test2() {

        int inputNumber = 12;

        String romanStringNumber = Task4.convertToRoman(inputNumber);

        Assertions.assertThat(romanStringNumber).isEqualTo("XII");
    }

    @Test
    @DisplayName("16 -> XVI")
    public void test3() {

        int inputNumber = 16;

        String romanStringNumber = Task4.convertToRoman(inputNumber);

        Assertions.assertThat(romanStringNumber).isEqualTo("XVI");
    }

    @Test
    @DisplayName("0 -> empty string")
    public void test4() {

        int inputNumber = 0;

        String romanStringNumber = Task4.convertToRoman(inputNumber);

        Assertions.assertThat(romanStringNumber).isEqualTo("");
    }

    @Test
    @DisplayName("10000 -> MMMMMMMMMM")
    public void test5() {

        int inputNumber = 10000;

        String romanStringNumber = Task4.convertToRoman(inputNumber);

        Assertions.assertThat(romanStringNumber).isEqualTo("MMMMMMMMMM");
    }

    @Test
    @DisplayName("-120 -> -CXX")
    public void test6() {

        int inputNumber = -120;

        String romanStringNumber = Task4.convertToRoman(inputNumber);

        Assertions.assertThat(romanStringNumber).isEqualTo("-CXX");
    }

    @Test
    @DisplayName("120 -> CXX")
    public void test7() {

        int inputNumber = 120;

        String romanStringNumber = Task4.convertToRoman(inputNumber);

        Assertions.assertThat(romanStringNumber).isEqualTo("CXX");
    }

    @Test
    @DisplayName("Integer.MAX_VALUE -> Throws exception. Number too big")
    public void test8() {

        int inputNumber = Integer.MAX_VALUE;

        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(inputNumber));
    }

    @Test
    @DisplayName("Integer.MIN_VALUE -> Throws exception. Number too small")
    public void test9() {

        int inputNumber = Integer.MIN_VALUE;

        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(inputNumber));
    }
}
