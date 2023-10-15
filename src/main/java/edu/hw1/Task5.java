package edu.hw1;

public class Task5 {

    private Task5() {
    }

    private static final int MINIMAL_PALINDROME = 11;

    public static boolean isPalindromeDescendant(int number) {
        int num = number;
        if (String.valueOf(num).length() % 2 != 0) {
            return false;
        }

        while (num >= MINIMAL_PALINDROME) {

            if (checkIfPalindrome(num)) {
                return true;
            }
            num = getDescendant(num);
        }
        return false;
    }

    private static boolean checkIfPalindrome(int number) {
        StringBuilder stringNum = new StringBuilder(number);
        return stringNum.compareTo(stringNum.reverse()) == 0;
    }

    private static int getDescendant(int number) {
        char[] arrNum = Character.toChars(number);
        StringBuilder resultNum = new StringBuilder();
        for (int index = 0; index < arrNum.length - 1; index += 2) {
            resultNum.append((int) arrNum[index] + (int) arrNum[index + 1]);
        }
        return Integer.parseInt(String.valueOf(resultNum));
    }
}
