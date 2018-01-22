package com.co.evolution.model.individual;

public interface Individual<T> extends Comparable<T> {

    public T get();

    public void set(T individual);

    public double getFitness();

    public void setFitness(double fitness);

    public abstract void initRandom(T min, T max);

    public abstract Individual<T> clone();
}
