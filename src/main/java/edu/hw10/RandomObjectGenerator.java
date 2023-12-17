package edu.hw10;

import java.lang.annotation.*;
import java.util.Random;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Retention(RetentionPolicy.RUNTIME)
@interface NotNull {}

@Retention(RetentionPolicy.RUNTIME)
@interface Min {
    int value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Max {
    int value();
}

public class RandomObjectGenerator {
    private final Random random;

    public RandomObjectGenerator() {
        this.random = new Random();
    }

    private int getRandomIntInRange(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private long getRandomLongInRange(long min, long max) {
        return (long) (random.nextDouble() * (max - min + 1) + min);
    }

    private double getRandomDoubleInRange(double min, double max) {
        return random.nextDouble() * (max - min) + min;
    }

    public <T> T nextObject(Class<T> clazz, String factoryMethod) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getName().equals(factoryMethod)) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] args = new Object[parameterTypes.length];
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();

                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    Annotation[] annotations = parameterAnnotations[i];

                    for (Annotation annotation : annotations) {
                        if (annotation.annotationType() == NotNull.class) {
                            args[i] = generateNotNullValue(parameterType);
                        } else if (annotation.annotationType() == Min.class) {
                            args[i] = generateMinValue(parameterType, ((Min) annotation).value());
                        } else if (annotation.annotationType() == Max.class) {
                            args[i] = generateMaxValue(parameterType, ((Max) annotation).value());
                        }
                    }

                    if (args[i] == null) {
                        // Генерация случайных значений для параметров конструктора
                        args[i] = generateRandomValue(parameterType);
                    }
                }

                return (T) constructor.newInstance(args);
            } else if (constructor.getParameterCount() == 0) {
                // Попытка использовать конструктор без параметров
                return (T) constructor.newInstance();
            }
        }

        // В случае, если нет фабричного метода или конструктора без параметров
        throw new IllegalArgumentException("Unable to find a suitable constructor or factory method.");
    }

    private Object generateNotNullValue(Class<?> parameterType) {
        // Генерация значения в зависимости от типа параметра
        return generateRandomValue(parameterType);
    }

    private Object generateMinValue(Class<?> parameterType, int minValue) {
        if (parameterType == int.class || Integer.class.isAssignableFrom(parameterType)) {
            return Math.max(getRandomIntInRange(minValue, Integer.MAX_VALUE), minValue);
        } else if (parameterType == long.class || Long.class.isAssignableFrom(parameterType)) {
            return Math.max(getRandomLongInRange(minValue, Long.MAX_VALUE), minValue);
        } else if (parameterType == double.class || Double.class.isAssignableFrom(parameterType)) {
            return Math.max(getRandomDoubleInRange(minValue, Double.MAX_VALUE), minValue);
        } else {
            return generateRandomValue(parameterType);
        }
    }

    private Object generateMaxValue(Class<?> parameterType, int maxValue) {
        if (parameterType == int.class || Integer.class.isAssignableFrom(parameterType)) {
            return Math.min(getRandomIntInRange(Integer.MIN_VALUE, maxValue), maxValue);
        } else if (parameterType == long.class || Long.class.isAssignableFrom(parameterType)) {
            return Math.min(getRandomLongInRange(Long.MIN_VALUE, maxValue), maxValue);
        } else if (parameterType == double.class || Double.class.isAssignableFrom(parameterType)) {
            return Math.min(getRandomDoubleInRange(Double.MIN_VALUE, maxValue), maxValue);
        } else {
            return generateRandomValue(parameterType);
        }
    }

    private Object generateRandomValue(Class<?> parameterType) {
        if (parameterType == int.class || Integer.class.isAssignableFrom(parameterType)) {
            return random.nextInt();
        } else if (parameterType == long.class || Long.class.isAssignableFrom(parameterType)) {
            return random.nextLong();
        } else if (parameterType == double.class || Double.class.isAssignableFrom(parameterType)) {
            return getRandomDoubleInRange(Double.MIN_VALUE, Double.MAX_VALUE);
        } else {
            return null;
        }
    }
}
