package edu.hw2.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Test from Test1 Function")
    void Test1() {
        CallingInfo info = CallingInfo.callingInfo();
        assertThat(info).extracting(CallingInfo::className, CallingInfo::methodName)
            .containsExactly("edu.hw2.task4.Task4Test", "Test1");
    }

    @Test
    @DisplayName("Test from Test2 Function")
    void Test2() {
        CallingInfo info = CallingInfo.callingInfo();
        assertThat(info).extracting(CallingInfo::className, CallingInfo::methodName)
            .containsExactly("edu.hw2.task4.Task4Test", "Test2");
    }
}
