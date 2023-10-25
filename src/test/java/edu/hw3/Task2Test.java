package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Task2Test {

    @Test
    @DisplayName("()()()")
    public void test1() {

        String inputString = "()()()";

        List<String> result = Task2.clusterize(inputString);

        Assertions.assertThat(result).containsExactly("()", "()", "()");
    }

    @Test
    @DisplayName("((()))")
    public void test2() {

        String inputString = "((()))";

        List<String> result = Task2.clusterize(inputString);

        Assertions.assertThat(result).containsExactly("((()))");
    }

    @Test
    @DisplayName("((()))(())()()(()())")
    public void test3() {

        String inputString = "((()))(())()()(()())";

        List<String> result = Task2.clusterize(inputString);

        Assertions.assertThat(result).containsExactly("((()))", "(())", "()", "()", "(()())");
    }

    @Test
    @DisplayName("((())())(()(()()))")
    public void test4() {

        String inputString = "((())())(()(()()))";

        List<String> result = Task2.clusterize(inputString);

        Assertions.assertThat(result).containsExactly("((())())", "(()(()()))");
    }

    @Test
    @DisplayName("Empty string")
    public void test5() {

        String inputString = "";

        List<String> result = Task2.clusterize(inputString);

        Assertions.assertThat(result).containsExactly();
    }

    // If cannot clusterize returns nothing
    @Test
    @DisplayName("Wrong sequence")
    public void test6() {

        String inputString = "((())";

        List<String> result = Task2.clusterize(inputString);

        Assertions.assertThat(result).containsExactly();
    }
}
