package edu.hw1;

public class Task7 {

    private Task7() {
    }

    //Стоит ли выносить общее в этих двух функциях, чтобы лучше соответствовать принципу DRY?

    public static int rotateLeft(int n, int shift) {
        String binary = String.format("%s", Integer.toBinaryString(n)).replace(' ', '0');
        char[] binArr = binary.toCharArray();
        char[] newArr = new char[binArr.length];
        int currentShift = shift % newArr.length;
        for (int i = 0; i < binArr.length; i++) {
            newArr[(i - currentShift + binArr.length) % binArr.length] = binArr[i];
        }
        String binResult = new String(newArr);
        return Integer.parseInt(binResult, 2);
    }

    public static int rotateRight(int n, int shift) {
        String binary = String.format("%s", Integer.toBinaryString(n)).replace(' ', '0');
        char[] binArr = binary.toCharArray();
        char[] newArr = new char[binArr.length];
        int currentShift = shift % newArr.length;
        for (int i = 0; i < binArr.length; i++) {
            newArr[(i + currentShift + binArr.length) % binArr.length] = binArr[i];
        }
        String binResult = new String(newArr);
        return Integer.parseInt(binResult, 2);
    }
}
