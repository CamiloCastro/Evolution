package com.co.evolution.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public abstract class Algorithm<T extends Comparable<T>> {

    List<ObjectiveFunction<T>> objectiveFunctions;
    List<GeneticOperator<T>> geneticOperators;
    TerminationCondition<T> terminationCondition;
    SelectionMethod<T> selectionMethod;
    PopulationInitialization<T> initialization;
    FitnessCalculation<T> fitnessCalculation;
    boolean minimize;

    public abstract void apply();

    public T getBest(List<T> population)
    {
        T best = population.get(0);
        for (int i = 1; i < population.size(); i++) {
            T actual = population.get(i);
            if (minimize && actual.compareTo(best) < 0)
                best = actual;
            else if (!minimize && actual.compareTo(best) > 0)
                best = actual;
        }
        return best;
    }


}
