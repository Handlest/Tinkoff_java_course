package edu.hw1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;


public class Task6 {
    private static final int KAPREKAR_CONSTANT = 6174;
    private static final int MINIMAL_NUMBER = 1000;
    private static final int MAXIMAL_NUMBER = 9999;

    private static final int DIGITS_AMOUNT_REQURED = 4;

    private Task6() {
    }

    public static int countK(int number) {
        if (number < MINIMAL_NUMBER || number > MAXIMAL_NUMBER) {
            throw new IllegalArgumentException("Введено не четырёхзначное число!");
        }
        if (number == KAPREKAR_CONSTANT) {
            return 0;
        }
        String stringNumber = Integer.toString(number);
        return findRecursiveK(stringNumber, 0);
    }

    private static int findRecursiveK(String stringNumber, int counter) {
        String descendingNumberString = getDescending(stringNumber);
        char[] ascendingNumberStringArray = descendingNumberString.toCharArray();
        Arrays.sort(ascendingNumberStringArray);
        String ascendingNumberString = new String(ascendingNumberStringArray);
        int descendingNumber = Integer.parseInt(descendingNumberString);
        int ascendingNumber = Integer.parseInt(ascendingNumberString);
        int result = descendingNumber - ascendingNumber;
        int resultCounter = counter + 1;
        if (result == KAPREKAR_CONSTANT) {
            return resultCounter;
        }
        String stringResult = Integer.toString(result);
        if (stringResult.length() < DIGITS_AMOUNT_REQURED) {
            stringResult = "0" + stringResult;
        }
        return findRecursiveK(stringResult, resultCounter);
    }

    /**
     * Returns number(string) with sorted digits reversed
     *
     * @param number is String representing some 4-digit number
     * @return String number with sorted in reverse order digits
     */
    private static @NotNull String getDescending(String number) {
        StringBuilder resultStr = new StringBuilder();
        char[] numberArr = number.toCharArray();
        Arrays.sort(numberArr);
        for (int i = numberArr.length - 1; i >= 0; i--) {
            resultStr.append(numberArr[i]);
        }
        return String.valueOf(resultStr);
    }
}
