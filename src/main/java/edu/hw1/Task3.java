package edu.hw1;

import java.util.Arrays;
import java.util.OptionalInt;

public class Task3 {

    private Task3() {
    }

    public static boolean isNestable(int[] firstArray, int[] secondArray) {
        OptionalInt firstMinimal = Arrays.stream(firstArray).min();
        OptionalInt firstMaximal = Arrays.stream(firstArray).max();
        OptionalInt secondMinimal = Arrays.stream(secondArray).min();
        OptionalInt secondMaximal = Arrays.stream(secondArray).max();
        if (firstMinimal.isEmpty() || secondMinimal.isEmpty()) {
            return true;
        }
        return firstMinimal.getAsInt() > secondMinimal.getAsInt()
            || firstMaximal.getAsInt() < secondMaximal.getAsInt();
    }
}



