package edu.hw2.task2;

public class Square extends Rectangle {
    private final int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    Rectangle setHeight(int height) {
        return new Rectangle(this.side, height);
    }

    @Override
    Rectangle setWidth(int width) {
        return new Rectangle(width, this.side);
    }

    @Override
    Square setSides(int side) {
        return (Square) super.setSides(side);
    }

    double area() {
        return side * side;
    }
}
