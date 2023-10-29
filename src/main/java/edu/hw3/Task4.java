package edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import static java.lang.Math.abs;

@SuppressWarnings("MagicNumber")
public class Task4 {

    private Task4() {
    }

    private static final int MAX_LIMIT = 1_000_000;
    private static final int MIN_LIMIT = -1_000_000;

    private static final LinkedHashMap<Integer, String> ARABIC_TO_ROMAN = new LinkedHashMap<>();

    static {
        ARABIC_TO_ROMAN.put(1, "I");
        ARABIC_TO_ROMAN.put(5, "V");
        ARABIC_TO_ROMAN.put(9, "IX");
        ARABIC_TO_ROMAN.put(10, "X");
        ARABIC_TO_ROMAN.put(40, "XL");
        ARABIC_TO_ROMAN.put(50, "L");
        ARABIC_TO_ROMAN.put(90, "XC");
        ARABIC_TO_ROMAN.put(100, "C");
        ARABIC_TO_ROMAN.put(400, "CD");
        ARABIC_TO_ROMAN.put(500, "D");
        ARABIC_TO_ROMAN.put(900, "CM");
        ARABIC_TO_ROMAN.put(1000, "M");
    }

    public static String convertToRoman(int number) {
        boolean isNegative = number < 0;
        if (number < MIN_LIMIT || number > MAX_LIMIT) {
            throw new IllegalArgumentException(
                "Введённое число слишком " + (number < MIN_LIMIT ? "Маленькое" : "Большое"));
        }
        ArrayList<Integer> numbersArray = new ArrayList<>(ARABIC_TO_ROMAN.keySet());
        numbersArray.sort(Comparator.reverseOrder());
        StringBuilder resultNumberString = new StringBuilder();
        if (isNegative) {
            resultNumberString.append('-');
        }
        int numberTemp = number;
        int currentNumberIndex = 0;
        while (numberTemp != 0) {
            if (numberTemp / numbersArray.get(currentNumberIndex) == 0) {
                currentNumberIndex++;
            }
            for (int i = 0; i < abs(numberTemp / numbersArray.get(currentNumberIndex));
                 i++) {  // Не работает для отрицательных чисел
                resultNumberString.append(ARABIC_TO_ROMAN.get(numbersArray.get(currentNumberIndex)));
            }
            numberTemp = numberTemp % numbersArray.get(currentNumberIndex);
        }
        return resultNumberString.toString();
    }
}
