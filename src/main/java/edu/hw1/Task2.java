package edu.hw1;

public class Task2 {
    private static final int ONE_DIGIT = 10;

    private Task2() {
    }

    public static int countDigits(int number) {
        int num = number;
        int result = 0;
        do {
            num /= ONE_DIGIT;
            result += 1;
        } while (num != 0);
        return result;
    }
}

