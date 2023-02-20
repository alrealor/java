package com.arao.challenges.topics.solidprinciples.openclose;

public class AreaCalculator {

    public double computeAreas(Shape[] shapes) {
        double result = 0;
        for(Shape shape: shapes) {
          result += shape.area();
        }
        System.out.println("Shapes areas = " + result);
        return result;
    }
}
