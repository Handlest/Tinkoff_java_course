package edu.hw3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private static final Map<Character, Character> LOOKUP_TABLE;

    private Task1() {
    }

    static {
        LOOKUP_TABLE = new HashMap<>();
        for (int i = (int) 'a', counter = 0; i <= (int) 'z'; i++, counter++) {
            LOOKUP_TABLE.put((char) i, (char) ((int) 'z' - counter));
            LOOKUP_TABLE.put(
                (char) (i + ((int) 'A' - (int) 'a')),
                (char) ((int) 'z' - counter + ((int) 'A' - (int) 'a'))
            );
        }
    }

    public static String atbash(String string) {
        StringBuilder result = new StringBuilder();
        char[] stringCharArray = string.toCharArray();
        for (char letter : stringCharArray) {
            if (LOOKUP_TABLE.containsKey(letter)) {
                result.append(LOOKUP_TABLE.get(letter));
            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }
}
