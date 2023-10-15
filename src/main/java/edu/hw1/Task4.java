package edu.hw1;

public class Task4 {

    private Task4() { }

    public static String fixString(String string) {
        char[] strArr = string.toCharArray();
        for (int index = 0; index < strArr.length - 1; index += 2) {
            char tmp = strArr[index];
            strArr[index] = strArr[index + 1];
            strArr[index + 1] = tmp;
        }
        return String.valueOf(strArr);
    }
}



