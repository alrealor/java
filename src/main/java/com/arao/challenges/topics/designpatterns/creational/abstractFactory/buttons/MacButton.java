package com.arao.challenges.topics.designpatterns.creational.abstractFactory.buttons;

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a MacOS variant of a button.
 */
public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("Paint Mac Button");
    }
}
