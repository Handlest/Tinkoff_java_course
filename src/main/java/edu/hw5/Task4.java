package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

    private Task4() {

    }

    public static boolean validatePassword(String string) {
        String regex = ".*[~!@#$%^&*|].*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
