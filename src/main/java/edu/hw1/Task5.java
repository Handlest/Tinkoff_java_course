package edu.hw1;

public class Task5 {

    private static final int MINIMAL_PALINDROME = 11;

    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        int num = number;
        if (String.valueOf(num).length() == 1) {
            return true;
        }
        while (num >= MINIMAL_PALINDROME) {
            if (isPalindrome(num)) {
                return true;
            }
            if (String.valueOf(num).length() % 2 != 0) {
                return false;
            }
            num = getDescendant(num);
        }
        return false;
    }

    private static boolean isPalindrome(int number) {
        StringBuilder stringNumber = new StringBuilder(Integer.toString(number));
        StringBuilder reversedNumber = new StringBuilder(stringNumber).reverse();
        return stringNumber.compareTo(reversedNumber) == 0;
    }

    private static int getDescendant(int number) {
        char[] numberArray = Integer.toString(number).toCharArray();
        StringBuilder resultNumber = new StringBuilder();
        for (int index = 0; index < numberArray.length - 1; index += 2) {
            resultNumber.append(Character.getNumericValue(numberArray[index])
                + Character.getNumericValue(numberArray[index + 1]));
        }
        return Integer.parseInt(String.valueOf(resultNumber));
    }
}
