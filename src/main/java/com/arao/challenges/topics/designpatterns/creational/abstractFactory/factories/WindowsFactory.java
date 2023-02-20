package com.arao.challenges.topics.designpatterns.creational.abstractFactory.factories;

import com.arao.challenges.topics.designpatterns.creational.abstractFactory.checkboxes.WindowsCheckbox;
import com.arao.challenges.topics.designpatterns.creational.abstractFactory.buttons.Button;
import com.arao.challenges.topics.designpatterns.creational.abstractFactory.checkboxes.Checkbox;
import com.arao.challenges.topics.designpatterns.creational.abstractFactory.buttons.WindowsButton;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
