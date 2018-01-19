package com.co.evolution.model;

public abstract class Individual<T> {

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

}
