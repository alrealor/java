package com.arao.challenges.topics.designpatterns.creational.factory;

import com.arao.challenges.topics.designpatterns.creational.factory.shapes.Rectangle;
import com.arao.challenges.topics.designpatterns.creational.factory.shapes.Triangle;
import com.arao.challenges.topics.designpatterns.creational.factory.shapes.Shape;
import com.arao.challenges.topics.designpatterns.creational.factory.shapes.Square;

public class ShapeFactory {

    private static final String SQUARE_TYPE = "SQUARE";
    private static final String RECTANGLE_TYPE = "RECTANGLE";
    private static final String TRIANGLE_TYPE = "TRIANGLE";

    /**
     * This method is used to create a shape given an specific type
     * @param shapeType - shape type name
     */
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        // return object by evaluating type
        if (shapeType.equalsIgnoreCase(SQUARE_TYPE)) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase(RECTANGLE_TYPE)) {
           return new Rectangle();
        } else if (shapeType.equalsIgnoreCase(TRIANGLE_TYPE)) {
            return new Triangle();
        }
        // return nul if type is none of the valid ones
        return null;
    }
}
