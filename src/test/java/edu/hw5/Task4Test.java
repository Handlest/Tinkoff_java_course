package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task4.validatePassword;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Wrong password")
    void Test1() {
        String password = "password";

        boolean isValid = validatePassword(password);

        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Good password")
    void Test2() {
        String password = "sdfsdf#fsfwgr";

        boolean isValid = validatePassword(password);

        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("Good password one symbol")
    void Test3() {
        String password = "#";

        boolean isValid = validatePassword(password);

        assertThat(isValid).isTrue();
    }
}
