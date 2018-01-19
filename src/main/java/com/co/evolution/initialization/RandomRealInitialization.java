package com.co.evolution.initialization;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.FitnessCalculation;
import com.co.evolution.model.PopulationInitialization;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class RandomRealInitialization implements PopulationInitialization<RealIndividual> {

    int size;
    double min;
    double max;

    @Override
    public List<RealIndividual> init(FitnessCalculation<RealIndividual> fitnessCalculation) {
        List<RealIndividual> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            RealIndividual ri = new RealIndividual();
            ri.initRandom(min, max);
            ri.setFitness(fitnessCalculation.calculate(ri));
            list.add(ri);
        }
        return list;
    }
}
