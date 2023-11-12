package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.isSubstring;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Right substring")
    void Test1() {
        String S = "this is main string to find substring in";
        String T = "string";

        boolean isSubstring = isSubstring(S, T);
        assertThat(isSubstring).isTrue();

    }

    @Test
    @DisplayName("Wrong substring")
    void Test2() {
        String S = "this is main string to find substring in";
        String T = "kaboom!";

        boolean isSubstring = isSubstring(S, T);
        assertThat(isSubstring).isFalse();
    }
}
