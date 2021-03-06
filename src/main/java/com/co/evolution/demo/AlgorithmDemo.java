package com.co.evolution.demo;

import com.co.evolution.algorithm.GeneticAlgorithm;
import com.co.evolution.algorithm.HAEA;
import com.co.evolution.fitness.RealFitnessCalculation;
import com.co.evolution.geneticoperators.RealCrossAverage;
import com.co.evolution.geneticoperators.RealMutation;
import com.co.evolution.geneticoperators.RealPickRandom;
import com.co.evolution.individual.RealIndividual;
import com.co.evolution.initialization.RandomRealInitialization;
import com.co.evolution.model.*;
import com.co.evolution.objectivefunction.DummyObjectiveFunction;
import com.co.evolution.objectivefunction.RastriginFunction;
import com.co.evolution.selection.TournamentSelection;
import com.co.evolution.terminationcondition.IterationsTerminationCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgorithmDemo {

    public static void main(String args[])
    {
        int dimensions = 10;
        Double[] min = new Double[dimensions];
        Double[] max = new Double[dimensions];

        Arrays.fill(min, -5.12);
        Arrays.fill(max, 5.12);

        int MAX_ITERATIONS = 10000;
        int POPULATION_SIZE = 100;

        List<ObjectiveFunction<RealIndividual>> objectiveFunctions = new ArrayList<>();
        objectiveFunctions.add(new RastriginFunction(true));

        List<GeneticOperator<RealIndividual>> geneticOperators = new ArrayList<>();
        geneticOperators.add(new RealCrossAverage());
        geneticOperators.add(new RealMutation(1.0, 0.0));
        geneticOperators.add(new RealPickRandom(4));

        TerminationCondition<RealIndividual> terminationCondition = new IterationsTerminationCondition(MAX_ITERATIONS);

        SelectionMethod<RealIndividual> selectionMethod = new TournamentSelection(4);

        PopulationInitialization<RealIndividual> initialization = new RandomRealInitialization(POPULATION_SIZE, min, max, dimensions);

        FitnessCalculation<RealIndividual> fitnessCalculation = new RealFitnessCalculation(objectiveFunctions);

        //GeneticAlgorithm<RealIndividual> ga = new GeneticAlgorithm<>(geneticOperators, terminationCondition, selectionMethod,true, initialization, fitnessCalculation);
        HAEA<RealIndividual> ga = new HAEA<>(geneticOperators, terminationCondition, selectionMethod,true, initialization, fitnessCalculation);

        List<RealIndividual> finalPop = ga.apply();

        RealIndividual best = ga.getBest(finalPop);

        System.out.println("Value: " + best.toString() + " Fitness: " + best.getFitness());




    }

}
