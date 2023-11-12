package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

    private static final int LAST_MONTH_NUMBER = 12;
    private static final int THIRTEEN_DAY_OF_MONTH = 13;

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private Task2() {

    }

    private static List<LocalDate> getAllFridays13LocalDates(int year) {
        LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);
        List<LocalDate> fridaysThe13th = new ArrayList<>();

        for (int month = 1; month <= LAST_MONTH_NUMBER; month++) {
            LocalDate date = firstDayOfYear.withMonth(month).withDayOfMonth(THIRTEEN_DAY_OF_MONTH);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridaysThe13th.add(date);
            }
        }
        return fridaysThe13th;
    }

    public static List<String> getAllFridays13(int year) {
        List<LocalDate> days = getAllFridays13LocalDates(year);
        return days.stream().map(localDate -> localDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)))
            .collect(Collectors.toList());
    }

    public static String getClosestFriday13(LocalDate date) {
        LocalDate nextFriday13th =
            date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (nextFriday13th.getDayOfMonth() != THIRTEEN_DAY_OF_MONTH) {
            nextFriday13th = nextFriday13th.plusWeeks(1);
        }
        return nextFriday13th.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

}
