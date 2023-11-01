package edu.hw4;

@SuppressWarnings("MutableException")
public class ValidationError extends Exception {
    private String message = "";

    public ValidationError(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
