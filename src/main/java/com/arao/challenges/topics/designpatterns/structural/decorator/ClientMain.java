package com.arao.challenges.topics.designpatterns.structural.decorator;

import com.arao.challenges.topics.designpatterns.structural.decorator.shape.Rectangle;
import com.arao.challenges.topics.designpatterns.structural.decorator.shape.Triangle;
import com.arao.challenges.topics.designpatterns.structural.decorator.shape.Shape;

/**
 * DECORATOR DESIGN PATTERN
 * - We will be creating a Shape Interface and concrete classes - Rectangle and Triangle that implement this Shape interface.
 * - We will be creating an abstract decorator class “ShapeDecorator” that implements the Shape interface.
 * - We will create RedColorDecorator class that extends ShapeDecorator.
 * We will be then using this decorator to implement the functionalities.
 */

public class ClientMain {

    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape redTriangle = new RedColorDecorator(new Triangle());
        Shape redRectangle = new RedColorDecorator(new Rectangle());

        // Draw normal triangle
        triangle.draw();
        System.out.println("--------------------------");

        // make the triangle red
        redTriangle.draw();
        System.out.println("--------------------------");

        // Make the rectangle red
        redRectangle.draw();
        System.out.println("--------------------------");
    }
}
