package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Task3Test {

    @Test
    @DisplayName("a, bb, a, bb")
    public void test1() {

        ArrayList<String> inputStringArray = new ArrayList<>(Arrays.asList("a", "bb", "a", "bb"));

        HashMap<String, Integer> result = Task3.freqDict(inputStringArray);

        Assertions.assertThat(result.get("a")).isEqualTo(2);
        Assertions.assertThat(result.get("bb")).isEqualTo(2);
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("this, and, that, and")
    public void test2() {

        ArrayList<String> inputStringArray = new ArrayList<>(Arrays.asList("this", "and", "that", "and"));

        HashMap<String, Integer> result = Task3.freqDict(inputStringArray);

        Assertions.assertThat(result.get("that")).isEqualTo(1);
        Assertions.assertThat(result.get("and")).isEqualTo(2);
        Assertions.assertThat(result.get("this")).isEqualTo(1);
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("код, код, код, bug")
    public void test3() {

        ArrayList<String> inputStringArray = new ArrayList<>(Arrays.asList("код", "код", "код", "bug"));

        HashMap<String, Integer> result = Task3.freqDict(inputStringArray);

        Assertions.assertThat(result.get("код")).isEqualTo(3);
        Assertions.assertThat(result.get("bug")).isEqualTo(1);
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("1, 1, 2, 2")
    public void test4() {

        ArrayList<Integer> inputStringArray = new ArrayList<>(Arrays.asList(1, 1, 2, 2));

        HashMap<Integer, Integer> result = Task3.freqDict(inputStringArray);

        Assertions.assertThat(result.get(1)).isEqualTo(2);
        Assertions.assertThat(result.get(2)).isEqualTo(2);
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Empty array")
    public void test5() {

        ArrayList<String> inputStringArray = new ArrayList<>();

        HashMap<String, Integer> result = Task3.freqDict(inputStringArray);

        Assertions.assertThat(result.size()).isEqualTo(0);
    }
}
