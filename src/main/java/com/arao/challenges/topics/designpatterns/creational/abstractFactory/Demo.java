package com.arao.challenges.topics.designpatterns.creational.abstractFactory;

import com.arao.challenges.topics.designpatterns.creational.abstractFactory.factories.GUIFactory;
import com.arao.challenges.topics.designpatterns.creational.abstractFactory.factories.MacFactory;
import com.arao.challenges.topics.designpatterns.creational.abstractFactory.factories.WindowsFactory;

/**
 * Abstract Factory
 *
 * This is a creational design pattern, which solves the problem of creating entire product families without specifying
 * their concrete classes.
 */
public class Demo {

    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        GUIFactory factory;

        final String OS = System.getProperty("os.name");
        if (OS.toLowerCase().equals("windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        return new Application(factory);
    }


    public static void main(String... args) {
        System.setProperty("os.name", "windows");
        Application app = configureApplication();
        app.paint();
    }
}
