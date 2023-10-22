package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class Task4 {

    private Task4() {
    }

    public static String fixString(@NotNull String string) {
        char[] stringCharArray = string.toCharArray();
        for (int index = 0; index < stringCharArray.length - 1; index += 2) {
            char temp = stringCharArray[index];
            stringCharArray[index] = stringCharArray[index + 1];
            stringCharArray[index + 1] = temp;
        }
        return String.valueOf(stringCharArray);
    }
}



