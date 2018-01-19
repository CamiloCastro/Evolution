package com.co.evolution.selection;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.SelectionMethod;

import java.util.List;

public class RouletteSelection implements SelectionMethod<RealIndividual> {

    private double[] acumm;

    @Override
    public void init(List<RealIndividual> individuals) {
        double sum = 0.0;
        for (RealIndividual individual : individuals) {
            sum += individual.get();
        }

        acumm = new double[individuals.size()];
        acumm[0] = individuals.get(0).get() / sum;

        for (int i = 1; i < individuals.size(); i++) {
            acumm[i] = acumm[i-1] + (individuals.get(i).get() / sum);
        }
    }

    @Override
    public List<RealIndividual> select(List<RealIndividual> individuals, int individualNumber) {
        return null;
    }
}
