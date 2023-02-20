package com.arao.challenges.topics.designpatterns.creational.abstractFactory.checkboxes;

/**
 * Abstract Factory assumes that you have several families of products,
 * structured into separate class hierarchies (Button/Checkbox). All products of
 * the same family have the common interface.
 *
 * This is the common interface for buttons family.
 */
public interface Checkbox {
    void paint();
}
