package com.co.evolution.geneticoperators;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.GeneticOperator;

import java.util.ArrayList;
import java.util.List;

public class RealCrossAverage extends GeneticOperator<RealIndividual> {

    public RealCrossAverage()
    {
        this.setCardinal(2);
    }


    @Override
    public List<RealIndividual> apply(List<RealIndividual> individuals) {

        List<RealIndividual> newIndividuals = new ArrayList<>();
        RealIndividual ri = new RealIndividual();
        ri.set((individuals.get(0).get() + individuals.get(1).get()) / 2);
        newIndividuals.add(ri);
        return newIndividuals;
    }
}
