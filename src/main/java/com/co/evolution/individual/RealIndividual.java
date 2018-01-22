package com.co.evolution.individual;

import com.co.evolution.model.individual.Individual;
import com.co.evolution.util.RandomUtils;

public class RealIndividual extends Individual<Double> implements Comparable<RealIndividual> {

    @Override
    public void initRandom(Double min, Double max) {
        set(RandomUtils.nextDouble(min, max));
    }

    @Override
    public Individual<Double> clone() {
        RealIndividual ri = new RealIndividual();
        ri.set(get());
        ri.setFitness(getFitness());
        return ri;
    }

    @Override
    public int compareTo(RealIndividual realIndividual) {
        return Double.compare(this.getFitness(), realIndividual.getFitness());
    }
}
