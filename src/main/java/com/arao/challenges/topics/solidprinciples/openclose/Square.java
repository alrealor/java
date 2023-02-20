package com.arao.challenges.topics.solidprinciples.openclose;

public class Square implements Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return Math.pow(width, 2);
    }
}
