package edu.project3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Log(String remoteAddress, String remoteUser, LocalDate time, String requestType, String address,
                  String codeStatus, int bytesSent, String httpReferer, String httpUserAgent) {
    @SuppressWarnings("MagicNumber")
    public static Log createLog(String rawLogString) {
        Matcher matcher = Pattern.compile(
                "^(\\S*) - (\\S*) \\[(\\d{1,2}/\\D{3}/\\d{1,4}).*\"(\\S*) (\\S*) .*\" (\\d{3}) (\\d+) \"(.*)\" \"(.*)$")
            .matcher(rawLogString);
        if (matcher.find()) {
            return new Log(matcher.group(1), matcher.group(2),
                LocalDate.parse(matcher.group(3), DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH)),
                matcher.group(4), matcher.group(5), matcher.group(6), Integer.parseInt(matcher.group(7)),
                matcher.group(8), matcher.group(9)
            );
        } else {
            throw new IllegalArgumentException("Invalid log string format.");
        }
    }
}
