/*
Implementation of mono-objective genetic algorithm.
Parameters:
Objective Function is the first of the objectiveFunctions list
Crossing operator is the firs of the geneticOperators list
Mutation operator is the second of the geneticOperator list


 */
package com.co.evolution.algorithm;

import com.co.evolution.model.*;
import com.co.evolution.model.individual.Individual;

import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithm<T extends Individual> extends Algorithm<T> {

    public GeneticAlgorithm(List<ObjectiveFunction<T>> objectiveFunctions, List<GeneticOperator<T>> geneticOperators, TerminationCondition<T> terminationCondition, SelectionMethod<T> selectionMethod, boolean minimize, PopulationInitialization<T> initialization, FitnessCalculation<T> fitnessCalculation) {
        super(objectiveFunctions, geneticOperators, terminationCondition, selectionMethod, initialization, fitnessCalculation, minimize);
    }

    @Override
    public List<T> apply() {
        int iteration = 1;
        List<T> pop = getInitialization().init(getFitnessCalculation());
        int size = pop.size();
        T best = getBest(pop);
        T bestBefore = null;
        GeneticOperator<T> crossOp = getGeneticOperators().get(0);
        GeneticOperator<T> mutateOp = getGeneticOperators().get(1);
        while(getTerminationCondition().getCondition(iteration, best, bestBefore))
        {
            List<T> newPop = new ArrayList<>();
            int numInd = 0;
            getSelectionMethod().init(pop);
            while(numInd < size)
            {
                List<T> parents = getSelectionMethod().select(pop, crossOp.getCardinal(), isMinimize());
                List<T> crossingInd = crossOp.apply(parents);
                List<T> mutateInd = mutateOp.apply(crossingInd);
                mutateInd.forEach(t -> t.setFitness(getFitnessCalculation().calculate(t)));
                newPop.addAll(mutateInd);
                numInd += mutateInd.size();
            }
            bestBefore = best;
            best = getBest(newPop);
            pop = newPop;
            iteration++;
        }
        return pop;
    }
}
