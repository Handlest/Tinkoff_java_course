package edu.project1;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Random;

interface Dictionary {
    Random random = new Random();
    String[] words = {"hello", "tinkoff", "java", "python", "hangman"};;
    @NotNull default ArrayList<Character> randomWord(){
        ArrayList<Character> result = new ArrayList<>();
        char[] tmp = words[random.nextInt(words.length+1)].toCharArray();
        for (char letter: tmp) {
            result.add(letter);
        }
        return result;
    };
}

