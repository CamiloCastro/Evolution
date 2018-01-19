package com.co.evolution.geneticoperators;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.GeneticOperator;
import com.co.evolution.util.RandomUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class RealMutation extends GeneticOperator<RealIndividual> {

    private double sigma;
    private double mean;

    public RealMutation(double sigma, double mean)
    {
        setCardinal(1);
        this.mean = mean;
        this.sigma = sigma;
    }

    @Override
    public List<RealIndividual> apply(List<RealIndividual> individuals) {
        List<RealIndividual> newIndividuals = new ArrayList<>();
        for (RealIndividual individual : individuals) {
            RealIndividual ri = new RealIndividual();
            ri.set(RandomUtils.nextGaussian(sigma, mean) + individual.get());
            newIndividuals.add(ri);
        }
        return newIndividuals;
    }
}
