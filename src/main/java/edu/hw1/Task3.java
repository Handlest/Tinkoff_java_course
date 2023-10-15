package edu.hw1;

import java.util.Arrays;
import java.util.OptionalInt;

public class Task3 {

    private Task3() { }

    public static boolean isNestable(int[] firstArr, int[] secondArr) {
        OptionalInt firstMin = Arrays.stream(firstArr).min();
        OptionalInt firstMax = Arrays.stream(firstArr).max();
        OptionalInt secondMin = Arrays.stream(secondArr).min();
        OptionalInt secondMax = Arrays.stream(secondArr).max();
        if (firstMin.isEmpty() || secondMin.isEmpty()) {
            return true;
        }
        return firstMin.getAsInt() > secondMin.getAsInt() || firstMax.getAsInt() < secondMax.getAsInt();
    }
}



