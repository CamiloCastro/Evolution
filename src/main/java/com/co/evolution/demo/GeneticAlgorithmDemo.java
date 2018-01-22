package com.co.evolution.demo;

import com.co.evolution.algorithm.GeneticAlgorithm;
import com.co.evolution.fitness.RealFitnessCalculation;
import com.co.evolution.geneticoperators.RealCrossAverage;
import com.co.evolution.geneticoperators.RealMutation;
import com.co.evolution.individual.RealIndividual;
import com.co.evolution.initialization.RandomRealInitialization;
import com.co.evolution.model.*;
import com.co.evolution.objectivefunction.DummyObjectiveFunction;
import com.co.evolution.selection.TournamentSelection;
import com.co.evolution.terminationcondition.IterationsTerminationCondition;

import java.util.ArrayList;
import java.util.List;

public class GeneticAlgorithmDemo {

    public static void main(String args[])
    {
        double min = -100.0;
        double max = 100.0;
        double sigma = 1.0;
        int MAX_ITERATIONS = 100;
        int POPULATION_SIZE = 50;

        List<ObjectiveFunction<RealIndividual>> objectiveFunctions = new ArrayList<>();
        objectiveFunctions.add(new DummyObjectiveFunction());

        List<GeneticOperator<RealIndividual>> geneticOperators = new ArrayList<>();
        geneticOperators.add(new RealCrossAverage());
        geneticOperators.add(new RealMutation(sigma, (min + max)/2));

        TerminationCondition<RealIndividual> terminationCondition = new IterationsTerminationCondition(MAX_ITERATIONS);

        SelectionMethod<RealIndividual> selectionMethod = new TournamentSelection(4);

        PopulationInitialization<RealIndividual> initialization = new RandomRealInitialization(POPULATION_SIZE, min, max);

        FitnessCalculation<RealIndividual> fitnessCalculation = new RealFitnessCalculation(objectiveFunctions);

        GeneticAlgorithm<RealIndividual> ga = new GeneticAlgorithm<RealIndividual>(objectiveFunctions, geneticOperators, terminationCondition, selectionMethod,true, initialization, fitnessCalculation);

        List<RealIndividual> finalPop = ga.apply();

        RealIndividual best = ga.getBest(finalPop);

        System.out.println("Value: " + best.get() + " Fitness: " + best.getFitness());




    }

}
