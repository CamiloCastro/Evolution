package com.co.evolution.model.individual;

public interface Individual extends Comparable<Individual> {

    public double getFitness();

    public void setFitness(double fitness);

    @Override
    int compareTo(Individual individual);

}
