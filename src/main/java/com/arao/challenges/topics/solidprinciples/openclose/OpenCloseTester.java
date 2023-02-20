package com.arao.challenges.topics.solidprinciples.openclose;

/**
 *
 * 	2. Open-Close Principle
 *
 * 	Software components (e.g., classes, modules, functions) should be open for an extension, but closed for modification.
 *
 */
public class OpenCloseTester {

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 3);
        Shape square = new Square(5);
        AreaCalculator calculator = new AreaCalculator();
        calculator.computeAreas(new Shape[] {rectangle, square});
    }
}
