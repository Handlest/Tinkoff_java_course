package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private static final int KAPREKAR_CONSTANT = 6174;
    private static final int MINIMAL_NUMBER = 1000;
    private static final int MAXIMAL_NUMBER = 9999;

    private Task6() {
    }

    public static int countK(int number) {
        if (number < MINIMAL_NUMBER || number > MAXIMAL_NUMBER) {
            throw new IllegalArgumentException();
        }
        if (number == KAPREKAR_CONSTANT) {
            return 0;
        }
        return findRecursiveK(number, 0);
    }

    private static int findRecursiveK(int number, int counter) {
        int ascending = getAscending(number);
        int descending = getDescending(number);
        int result = descending - ascending;
        int resultCounter = counter + 1;
        if (result == KAPREKAR_CONSTANT) {
            return resultCounter;
        }
        return findRecursiveK(result, resultCounter);
    }

    private static int getAscending(int number) {
        StringBuilder resultStr = new StringBuilder();
        char[] numberArr = Integer.toString(number).toCharArray();
        Arrays.sort(numberArr);
        for (char elem : numberArr) {
            resultStr.append(elem);
        }
        return Integer.parseInt(String.valueOf(resultStr));
    }

    private static int getDescending(int number) {
        StringBuilder resultStr = new StringBuilder();
        char[] numberArr = Integer.toString(number).toCharArray();
        Arrays.sort(numberArr);
        for (int i = numberArr.length - 1; i >= 0; i--) {
            resultStr.append(numberArr[i]);
        }
        return Integer.parseInt(String.valueOf(resultStr));
    }
}
