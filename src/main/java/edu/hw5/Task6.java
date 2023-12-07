package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {

    private Task6() {

    }

    public static boolean isSubstring(String s, String t) {
        StringBuilder patternString = new StringBuilder();
        for (char c : s.toCharArray()) {
            patternString.append(c).append(".*");
        }

        Pattern pattern = Pattern.compile(patternString.toString());

        Matcher matcher = pattern.matcher(t);

        return matcher.find();
    }
}
