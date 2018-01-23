package com.co.evolution.model.individual;

public abstract class IndividualImpl<T> implements Individual {

    private T individual;
    private double fitness;

    public T get() {
        return individual;
    }

    public void set(T individual) {
        this.individual =  individual;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public abstract void initRandom(T min, T max);

    public abstract Individual clone();

    @Override
    public int compareTo(Individual individual) {
        return Double.compare(this.fitness, individual.getFitness());
    }
}
