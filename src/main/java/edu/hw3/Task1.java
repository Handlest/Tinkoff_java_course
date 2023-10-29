package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private static Map<Character, Character> lookupTable;

    private Task1() {
    }

    static {
        lookupTable = new HashMap<>();
        for (int i = (int) 'a', counter = 0; i <= (int) 'z'; i++, counter++) {
            lookupTable.put((char) i, (char) ((int) 'z' - counter));
            lookupTable.put(
                (char) (i + ((int) 'A' - (int) 'a')),
                (char) ((int) 'z' - counter + ((int) 'A' - (int) 'a'))
            );
        }
    }

    public static String atbash(String string) {
        StringBuilder result = new StringBuilder();
        char[] stringCharArray = string.toCharArray();
        for (char letter : stringCharArray) {
            if (lookupTable.containsKey(letter)) {
                result.append(lookupTable.get(letter));
            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }
}
