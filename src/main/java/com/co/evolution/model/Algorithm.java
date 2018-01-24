package com.co.evolution.model;

import com.co.evolution.model.individual.Individual;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public abstract class Algorithm<T extends Individual> {

    List<GeneticOperator<T>> geneticOperators;
    TerminationCondition<T> terminationCondition;
    SelectionMethod<T> selectionMethod;
    PopulationInitialization<T> initialization;
    FitnessCalculation<T> fitnessCalculation;
    boolean minimize;

    public abstract List<T> apply();

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
