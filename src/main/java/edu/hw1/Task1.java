package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int ERROR_CODE = -1;

    private Task1() { }

    public static int minutesToSeconds(@NotNull String duration) {

        if (!duration.matches("[0-9]+:[0-5][0-9]")) {
            return ERROR_CODE;
        }

        String[] arr = duration.split(":");

        try {
            int minutes = Integer.parseInt(arr[0]);
            int seconds = Integer.parseInt(arr[1]);
            return (minutes * SECONDS_IN_MINUTE) + seconds;
        } catch (NumberFormatException ex) {
            return ERROR_CODE;
        }
    }
}
