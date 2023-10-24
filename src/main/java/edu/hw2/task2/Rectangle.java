package edu.hw2.task2;

public class Rectangle {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {

    }

    Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }

    Rectangle setSides(int side){
        return new Square(side);
    }

    double area() {
        return width * height;
    }
}
