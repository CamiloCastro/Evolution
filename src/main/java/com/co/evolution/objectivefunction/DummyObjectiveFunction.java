/*
* Objective function = x^2
* */
package com.co.evolution.objectivefunction;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.ObjectiveFunction;

public class DummyObjectiveFunction implements ObjectiveFunction<RealIndividual> {
    @Override
    public double apply(RealIndividual individual) {
        return individual.get() * individual.get();
    }
}
