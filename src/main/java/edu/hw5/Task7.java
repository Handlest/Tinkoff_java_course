package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task7 {

    private Task7() {

    }

    public static boolean validateAlphabetThird0(String string) {
        String regex = "^[01]{2}0[01]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    @SuppressWarnings("MagicNumber")
    public static boolean validateStartEqualsEnd(String string) {
        String regex = "^([01])([01]*)([01])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches() && matcher.group(1).equals(matcher.group(3));
    }

    public static boolean validateLengthBetween1And3(String string) {
        String regex = "^[01]{1,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
