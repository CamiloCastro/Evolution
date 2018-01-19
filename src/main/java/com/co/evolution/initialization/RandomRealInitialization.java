package com.co.evolution.initialization;

import com.co.evolution.individual.RealIndividual;
import com.co.evolution.model.PopulationInitialization;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RandomRealInitialization implements PopulationInitialization<RealIndividual> {

    int size;
    double min;
    double max;

    @Override
    public List<RealIndividual> init() {

        return null;
    }
}
