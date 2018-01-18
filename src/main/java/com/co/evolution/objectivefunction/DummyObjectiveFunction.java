/*
* Objective function = x^2
* */
package com.co.evolution.objectivefunction;

import com.co.evolution.model.ObjectiveFunction;

public class DummyObjectiveFunction implements ObjectiveFunction<Double> {
    @Override
    public double apply(Double individual) {
        return individual * individual;
    }
}
