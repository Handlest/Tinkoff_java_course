package edu.hw2.task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length >= 2) {
            StackTraceElement caller = stackTrace[1];
            return new CallingInfo(caller.getClassName(), caller.getMethodName());
        }
        return null;
        // Если стек вызова пуст или отсутствует один из аргументов (такое может произойти?
        // Я не придумал как это тестировать)
    }
}
