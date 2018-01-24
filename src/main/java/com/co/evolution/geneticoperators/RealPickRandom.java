package com.co.evolution.geneticoperators;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.GeneticOperator;
import com.co.evolution.util.RandomUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class RealPickRandom extends GeneticOperator <RealIndividual> {

    private int select;

    public RealPickRandom(int select)
    {
        setCardinal(1);
        this.select = select;
    }

    @Override
    public List<RealIndividual> apply(List<RealIndividual> individuals) {
        List<RealIndividual> newIndividuals = new ArrayList<>();
        for (RealIndividual individual : individuals) {
            RealIndividual ri = (RealIndividual) individual.clone();
            HashSet<Integer> indexes = RandomUtils.getDifferentRandomIntegers(individual.getDimensions(),select);
            for (Integer index : indexes) {
                ri.get()[index] += RandomUtils.nextGaussian(1.0,0.0);
            }
            newIndividuals.add(ri);
        }
        return newIndividuals;
    }
}
