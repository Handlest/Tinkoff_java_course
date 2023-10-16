package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int ERROR_CODE = -1;
    private static final int MAXIMAL_MINUTES = 35791335;

    private Task1() {
    }

    public static int minutesToSeconds(@NotNull String duration) {

        if (!duration.matches("[0-9]+:[0-5][0-9]")) {
            return ERROR_CODE;
        }

        String[] durationSplitted = duration.split(":");

        try {
            int minutes = Integer.parseInt(durationSplitted[0]);
            int seconds = Integer.parseInt(durationSplitted[1]);
            if (minutes > MAXIMAL_MINUTES) {
                return ERROR_CODE;
            }
            return (minutes * SECONDS_IN_MINUTE) + seconds;
        } catch (NumberFormatException ex) {
            return ERROR_CODE;
        }
    }
}
