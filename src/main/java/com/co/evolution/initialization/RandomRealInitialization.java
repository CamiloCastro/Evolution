package com.co.evolution.initialization;

import com.co.evolution.model.Individual;
import com.co.evolution.model.PopulationInitialization;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RandomRealInitialization implements PopulationInitialization<Double> {

    int size;

    @Override
    public List<Individual<Double>> init() {
        return null;
    }
}
