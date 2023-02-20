package com.arao.challenges.topics.solidprinciples.liskovsubstitution.cars;

import com.arao.challenges.topics.solidprinciples.liskovsubstitution.engines.CombustionEngine;
import com.arao.challenges.topics.solidprinciples.liskovsubstitution.engines.Engine;

public class MotorCar extends Car implements CombustionEngine {

    public Engine engine = new Engine();

    public MotorCar(String type) {
        super(type);
    }

    @Override
    public void turnOnCombustionEngine() {
        engine.engineOn();
    }
}
