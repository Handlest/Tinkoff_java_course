package edu.hw2.Task2;

public class Square extends Rectangle {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    void setSide(int side) {
        this.side = side;
    }

    double area() {
        return side * side;
    }
}
