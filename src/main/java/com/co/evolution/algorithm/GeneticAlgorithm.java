/*
Implementation of mono-objective genetic algorithm.
Parameters:
Objective Function is the first of the objectiveFunctions list
Crossing operator is the firs of the geneticOperators list
Mutation operator is the second of the geneticOperator list


 */
package com.co.evolution.algorithm;

import com.co.evolution.model.*;

import java.util.List;

public class GeneticAlgorithm<T> extends Algorithm<T> {

    public GeneticAlgorithm(List<ObjectiveFunction<T>> objectiveFunctions, List<GeneticOperator<T>> geneticOperators, TerminationCondition<T> terminationCondition, SelectionMethod<T> selectionMethod, boolean minimize, PopulationInitialization<T> initialization) {
        super(objectiveFunctions, geneticOperators, terminationCondition, selectionMethod, initialization, minimize);
    }

    @Override
    public void apply() {
        int iteration = 1;
        List<T> pop = getInitialization().init();
        T best = null;
        while(getTerminationCondition().getCondition(iteration, best, 0))
        {

            iteration++;
        }
    }
}
