package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private Task3() {

    }

    @SuppressWarnings({"ReturnCount", "MagicNumber"})
    public static Optional<LocalDate> parseDate(String string) {
        String regex =
            "(\\d+-\\d{1,2}-\\d{1,2})|(\\d{1,2}/\\d{1,2}/\\d+)|(tomorrow|today|yesterday)|(\\d+ (day|days) ago)";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);

        if (matcher.matches()) {
            if (matcher.group(1) != null) {
                String[] parsedStringArray = matcher.group(1).split("-");
                return Optional.of(LocalDate.of(
                    Integer.parseInt(parsedStringArray[0]),
                    Integer.parseInt(parsedStringArray[1]),
                    Integer.parseInt(parsedStringArray[2])
                ));
            } else if (matcher.group(2) != null) {
                String[] parsedStringArray = matcher.group(2).split("/");
                return Optional.of(LocalDate.of(
                    Integer.parseInt(parsedStringArray[2]),
                    Integer.parseInt(parsedStringArray[1]),
                    Integer.parseInt(parsedStringArray[0])
                ));
            } else if (matcher.group(3) != null) {
                String date = matcher.group(3);
                switch (date) {
                    case "tomorrow" -> {
                        return Optional.of(LocalDate.now().plusDays(1));
                    }
                    case "today" -> {
                        return Optional.of(LocalDate.now());
                    }
                    case "yesterday" -> {
                        return Optional.of(LocalDate.now().minusDays(1));
                    }
                    default -> {
                        return Optional.empty();
                    }
                }
            } else if (matcher.group(4) != null) {
                String daysAgo = matcher.group(4);
                int days = Integer.parseInt(daysAgo.split(" ")[0]);
                return Optional.of(LocalDate.now().minusDays(days));
            }
        }
        return Optional.empty();
    }
}
