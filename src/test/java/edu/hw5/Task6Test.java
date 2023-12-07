package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.isSubstring;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Right substring")
    void Test1() {
        String T = "this is main string to find substring in";
        String S = "string";

        boolean isSubstring = isSubstring(S, T);
        assertThat(isSubstring).isTrue();

    }

    @Test
    @DisplayName("Wrong substring")
    void Test2() {
        String T = "this is main string to find substring in";
        String S = "kaboom!";

        boolean isSubstring = isSubstring(S, T);
        assertThat(isSubstring).isFalse();
    }

    @Test
    @DisplayName("Right substring")
    void Test3() {
        String T = "this is main string to find substring in";
        String S = "tmin";

        boolean isSubstring = isSubstring(S, T);
        assertThat(isSubstring).isTrue();
    }

    @Test
    @DisplayName("Right substring")
    void Test4() {
        String T = "aghfbdkeoc";
        String S = "abc";

        boolean isSubstring = isSubstring(S, T);
        assertThat(isSubstring).isTrue();
    }
}
