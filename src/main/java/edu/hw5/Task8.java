package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task8 {

    private Task8() {

    }

    public static boolean validateHasUnevenLength(String string) {
        String regex = "^([01])(([01]{2})+)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static boolean validateStarts0UnevenOrStarts1Even(String string) {
        String regex = "^(0(([01]{2})+)?)$|^(1[01](([01]{2})+)?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches() && validateAlphabet(string);
    }

    @SuppressWarnings("MagicNumber")
    public static boolean validate0multiple3(String string) {
        String regex = "(0)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        int zerosCounter = 0;
        while (matcher.find()) {
            zerosCounter++;
        }
        return zerosCounter % 3 == 0 && zerosCounter != 0 && validateAlphabet(string);
    }

    public static boolean validateAnyExcept11And111(String string) {
        String regex = "^(111)$|^(11)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return !matcher.matches() && validateAlphabet(string);
    }

    public static boolean validateNoSequential1(String string) {
        String regex = "^(?!.*11)[01]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches() && validateAlphabet(string);
    }

    private static boolean validateAlphabet(String string) {
        String regex = "^[01]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
