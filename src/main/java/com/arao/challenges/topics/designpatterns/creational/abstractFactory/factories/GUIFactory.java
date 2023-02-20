package com.arao.challenges.topics.designpatterns.creational.abstractFactory.factories;

import com.arao.challenges.topics.designpatterns.creational.abstractFactory.buttons.Button;
import com.arao.challenges.topics.designpatterns.creational.abstractFactory.checkboxes.Checkbox;

public interface GUIFactory {
    public Button createButton();
    public Checkbox createCheckbox();
}
