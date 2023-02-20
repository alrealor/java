package com.arao.challenges.topics.designpatterns.creational.abstractFactory.checkboxes;

/**
 * All products families have the same varieties (MacOS/Windows).
 *
 * This is a Windows variant of a checkbox.
 */
public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("Paint Windows Checkbox");
    }
}
