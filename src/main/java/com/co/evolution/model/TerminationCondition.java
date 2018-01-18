package com.co.evolution.model;

public interface TerminationCondition<T> {

    boolean getCondition(int actualIteration, Individual<T> bestIndividual, double differenceBetweenBests);

}
