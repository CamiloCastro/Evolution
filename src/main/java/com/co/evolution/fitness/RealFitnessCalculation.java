package com.co.evolution.fitness;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.FitnessCalculation;
import com.co.evolution.model.ObjectiveFunction;

import java.util.List;

public class RealFitnessCalculation extends FitnessCalculation<RealIndividual> {

    public RealFitnessCalculation(List<ObjectiveFunction<RealIndividual>> objectiveFunctions) {
        super(objectiveFunctions);
    }

    @Override
    public double calculate(RealIndividual individual, List<RealIndividual> population) {
        return individual.getObjectiveFunctionValues().get(0);
    }
}
