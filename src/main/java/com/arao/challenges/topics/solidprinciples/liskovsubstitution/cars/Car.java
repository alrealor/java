package com.arao.challenges.topics.solidprinciples.liskovsubstitution.cars;

// Car class contains all basic functions for a Car
public class Car {

    private String type;

    public Car(String type) {
        this.type = type + " car";
    }

    public void accelerate(double acceleration) {
        System.out.println(type + " moving forward to " + acceleration + " mph");
    }
}
