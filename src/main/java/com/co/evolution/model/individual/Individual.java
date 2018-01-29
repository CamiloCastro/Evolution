package com.co.evolution.model.individual;

import java.util.List;

public interface Individual extends Comparable<Individual> {

    public double getFitness();

    public void setFitness(double fitness);

    public List<Double> getObjectiveFunctionValues();

    @Override
    int compareTo(Individual individual);

    @Override
    String toString();

}
