package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {

    private static final String DATETIME_PATTERN = "yyyy-MM-dd, HH:mm";

    private Task1() {

    }

    public static String getAnalytics(String rawStringData) {
        List<String> sessions = rawStringData.lines().toList();
        Duration totalDuration = Duration.ZERO;

        for (String session : sessions) {
            String[] parts = session.split(" - ");
            LocalDateTime start = LocalDateTime.parse(parts[0], DateTimeFormatter.ofPattern(DATETIME_PATTERN));
            LocalDateTime end = LocalDateTime.parse(parts[1], DateTimeFormatter.ofPattern(DATETIME_PATTERN));
            Duration sessionDuration = Duration.between(start, end);
            totalDuration = totalDuration.plus(sessionDuration);
        }
        totalDuration = totalDuration.dividedBy(sessions.size());
        long hours = totalDuration.toHours();
        long minutes = totalDuration.toMinutesPart();
        return hours + "ч " + minutes + "м";
    }
}

