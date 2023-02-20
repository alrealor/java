package com.arao.challenges.topics.designpatterns.creational.abstractFactory.factories;

import com.arao.challenges.topics.designpatterns.creational.abstractFactory.checkboxes.MacCheckbox;
import com.arao.challenges.topics.designpatterns.creational.abstractFactory.buttons.Button;
import com.arao.challenges.topics.designpatterns.creational.abstractFactory.checkboxes.Checkbox;
import com.arao.challenges.topics.designpatterns.creational.abstractFactory.buttons.MacButton;

public class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
