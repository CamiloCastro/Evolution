package com.co.evolution.fitness;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.FitnessCalculation;
import com.co.evolution.model.ObjectiveFunction;

import java.util.List;

public class SPEAFitnessCalculation extends FitnessCalculation<RealIndividual> {

    public SPEAFitnessCalculation(List<ObjectiveFunction<RealIndividual>> objectiveFunctions) {
        super(objectiveFunctions);
    }

    @Override
    public double calculate(RealIndividual individual, List<RealIndividual> population) {
        return 0;
    }
}
