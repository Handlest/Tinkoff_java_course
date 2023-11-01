package edu.hw4;

import java.util.HashMap;
import java.util.Map;

public class Validators {

    private static final int AGE_LIMIT = 100;
    private static final int HEIGHT_LIMIT = 10000;
    private static final int WEIGHT_LIMIT = 200000;

    private Validators() {

    }

    private static boolean validateAge(Animal animal) {
        return animal.age() < AGE_LIMIT && animal.age() > 0;
    }

    private static boolean validateHeight(Animal animal) {
        return animal.height() < HEIGHT_LIMIT && animal.height() > 0;
    }

    private static boolean validateWeight(Animal animal) {
        return animal.weight() < WEIGHT_LIMIT && animal.weight() > 0;
    }

    public static Map<String, ValidationError> validateAnimal(Animal animal) {
        Map<String, ValidationError> errorMap = new HashMap<>();
        if (!validateHeight(animal)) {
            errorMap.put(animal.name(), new ValidationError("Height error"));
        }
        if (!validateWeight(animal)) {
            errorMap.put(animal.name(), new ValidationError("Weight error"));
        }
        if (!validateAge(animal)) {
            errorMap.put(animal.name(), new ValidationError("Age error"));
        }
        return errorMap;
    }
}
