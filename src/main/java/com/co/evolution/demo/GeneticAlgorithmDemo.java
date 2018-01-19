package com.co.evolution.demo;

import com.co.evolution.algorithm.GeneticAlgorithm;
import com.co.evolution.geneticoperators.RealCrossAverage;
import com.co.evolution.geneticoperators.RealMutation;
import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.GeneticOperator;
import com.co.evolution.model.ObjectiveFunction;
import com.co.evolution.model.TerminationCondition;
import com.co.evolution.objectivefunction.DummyObjectiveFunction;
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

        List<ObjectiveFunction<RealIndividual>> objectiveFunctions = new ArrayList<>();
        objectiveFunctions.add(new DummyObjectiveFunction());

        List<GeneticOperator<RealIndividual>> geneticOperators = new ArrayList<>();
        geneticOperators.add(new RealCrossAverage());
        geneticOperators.add(new RealMutation(sigma, (min + max)/2));

        TerminationCondition<RealIndividual> terminationCondition = new IterationsTerminationCondition(MAX_ITERATIONS);

        GeneticAlgorithm<RealIndividual> ga = new GeneticAlgorithm<RealIndividual>(objectiveFunctions, geneticOperators, terminationCondition,,true,,);




    }

}
