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
        int dimensions = individuals.get(0).getDimensions();
        List<RealIndividual> newIndividuals = new ArrayList<>();
        for (RealIndividual individual : individuals) {
            RealIndividual ri = new RealIndividual(dimensions);
            for (int i = 0; i < dimensions; i++) {
                ri.get()[i] = RandomUtils.nextGaussian(sigma, mean) + individual.get()[i];
            }
            newIndividuals.add(ri);
        }
        return newIndividuals;
    }
}
