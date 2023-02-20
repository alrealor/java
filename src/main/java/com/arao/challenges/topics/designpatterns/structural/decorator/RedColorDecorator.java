package com.arao.challenges.topics.designpatterns.structural.decorator;

import com.arao.challenges.topics.designpatterns.structural.decorator.shape.Shape;

public class RedColorDecorator extends ShapeDecorator {

    public RedColorDecorator(Shape shapeDecorated) {
        super(shapeDecorated);
    }

    @Override
    public void draw() {
        shapeDecorated.draw();
        this.setRedBorder(shapeDecorated);
    }

    private void setRedBorder(Shape shapeDecorated) {
        System.out.println("Red color border added");
    }
}
