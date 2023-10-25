package edu.hw3;

import java.util.HashMap;
import java.util.List;

public class Task3 {
    public static <T> HashMap<T, Integer> freqDict(List<T> arr) {
        HashMap<T, Integer> freqDictionary = new HashMap<>();
        for(T word: arr){
            freqDictionary.put(word, freqDictionary.getOrDefault(word, 0) + 1);
        }
        return freqDictionary;
    }
}
