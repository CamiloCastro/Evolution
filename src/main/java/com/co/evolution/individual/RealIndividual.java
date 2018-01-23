package com.co.evolution.individual;

import com.co.evolution.model.individual.Individual;
import com.co.evolution.model.individual.IndividualImpl;
import com.co.evolution.util.RandomUtils;

public class RealIndividual extends IndividualImpl<Double> {

    @Override
    public void initRandom(Double min, Double max) {
        set(RandomUtils.nextDouble(min, max));
    }

    @Override
    public Individual clone() {
        RealIndividual ri = new RealIndividual();
        ri.set(get());
        ri.setFitness(getFitness());
        return ri;
    }
}
