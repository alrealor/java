package com.arao.challenges.topics.designpatterns.creational.factory;

import com.arao.challenges.topics.designpatterns.creational.factory.shapes.Shape;

public class ClientMain {

    /**
     * FACTORY design pattern
     *
     * Let’s consider 3 classes Square, Rectangle and Triangle. We will be using factory patterns to create objects of
     * these three classes without exposing the creation logic by making use of ShapeFactory class. The Driver class
     * would be passing the information like RECTANGLE/SQUARE/TRIANGLE for getting the required object
     *
     */
    public static void main(String... args) {

        // use factory class to get the object required based on description
        ShapeFactory shapeFactory = new ShapeFactory();

        // get square object and call draw
        Shape square = shapeFactory.getShape("square");
        square.draw();

        // get triangle object and call draw
        Shape triangle = shapeFactory.getShape("Triangle");
        triangle.draw();

        // get square object and call draw
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
    }
}
