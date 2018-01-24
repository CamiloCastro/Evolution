package com.co.evolution.algorithm;

import com.co.evolution.model.*;
import com.co.evolution.model.individual.Individual;
import com.co.evolution.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class HAEA<T extends Individual> extends Algorithm<T> {

    public HAEA(List<GeneticOperator<T>> geneticOperators, TerminationCondition<T> terminationCondition, SelectionMethod<T> selectionMethod, boolean minimize, PopulationInitialization<T> initialization, FitnessCalculation<T> fitnessCalculation) {
        super(geneticOperators, terminationCondition, selectionMethod, initialization, fitnessCalculation, minimize);
    }

    @Override
    public List<T> apply() {
        int iteration = 1;
        List<T> pop = getInitialization().init(getFitnessCalculation());
        int size = pop.size();
        T best = getBest(pop);
        T bestBefore = null;
        double[][] prob = new double[size][getGeneticOperators().size()];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < getGeneticOperators().size(); j++) {
                prob[i][j] = 1.0/getGeneticOperators().size();
            }
        }

        while(getTerminationCondition().getCondition(iteration, best, bestBefore))
        {
            System.out.println("Value: " + best.toString() + " Fitness: " + best.getFitness());
            List<T> newPop = new ArrayList<>();
            getSelectionMethod().init(pop);
            for (int i = 0; i < size; i++) {
                T actualIndividual = pop.get(i);
                int selectedOGIndex = RandomUtils.nextIntegerWithDefinedDistribution(prob[i]);
                GeneticOperator<T> selectedGO = getGeneticOperators().get(selectedOGIndex);
                List<T> parents = new ArrayList<>();
                parents.add(actualIndividual);
                if(selectedGO.getCardinal() > 1)
                {
                    List<T> selectedParents = getSelectionMethod().select(pop, selectedGO.getCardinal() - 1,isMinimize());
                    parents.addAll(selectedParents);
                }
                List<T> children = selectedGO.apply(parents);
                for (T child : children) {
                    child.setFitness(getFitnessCalculation().calculate(child, pop));
                }
                children.add(actualIndividual);
                T childrenBest = getBest(children);
                if (childrenBest == actualIndividual || childrenBest.getFitness() == actualIndividual.getFitness())
                {
                    //punish
                    modifyProbabilities(-1, prob[i],selectedOGIndex);
                }
                else
                {
                    //reward
                    modifyProbabilities(1, prob[i],selectedOGIndex);
                }
                newPop.add(childrenBest);
            }
            bestBefore = best;
            best = getBest(newPop);
            pop = newPop;
            iteration++;
        }

        return pop;
    }

    private void modifyProbabilities(int sign, double[] prob, int selectedOGIndex)
    {
        double num = RandomUtils.nextDouble(0,1);
        num *= sign;
        prob[selectedOGIndex] += num;
        prob[selectedOGIndex] = prob[selectedOGIndex] < 0 ? prob[selectedOGIndex]*-1 : prob[selectedOGIndex];
        double sum = 0.0;
        for (double aProb : prob) {
            sum += aProb;
        }
        for (int i = 0; i < prob.length; i++) {
            prob[i] /= sum;
        }
    }





}
