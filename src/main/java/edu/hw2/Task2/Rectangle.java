package edu.hw2.Task2;

public class Rectangle{
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {

    }

    final void setWidth(int width) {
        this.width = width;
    }

    final void setHeight(int height) {
        this.height = height;
    }

    double area() {
        return width * height;
    }
}
