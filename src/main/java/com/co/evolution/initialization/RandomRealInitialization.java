package com.co.evolution.initialization;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.FitnessCalculation;
import com.co.evolution.model.ObjectiveFunction;
import com.co.evolution.model.PopulationInitialization;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class RandomRealInitialization implements PopulationInitialization<RealIndividual> {

    int size;
    Double[] min;
    Double[] max;
    int dimensions;

    @Override
    public List<RealIndividual> init(FitnessCalculation<RealIndividual> fitnessCalculation) {
        List<RealIndividual> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            RealIndividual ri = new RealIndividual(dimensions);
            ri.initRandom(min, max);
            for (int j = 0; j < fitnessCalculation.getObjectiveFunctions().size(); j++) {
                ri.getObjectiveFunctionValues().add(fitnessCalculation.getObjectiveFunctions().get(j).apply(ri));
            }
            list.add(ri);
        }
        for (RealIndividual ri : list) {
            ri.setFitness(fitnessCalculation.calculate(ri,list));
        }
        return list;
    }
}
