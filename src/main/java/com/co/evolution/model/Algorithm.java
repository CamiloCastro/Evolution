package com.co.evolution.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public abstract class Algorithm<T> {

    List<ObjectiveFunction<T>> objectiveFunctions;
    List<GeneticOperator<T>> geneticOperators;
    TerminationCondition<T> terminationCondition;
    SelectionMethod<T> selectionMethod;
    PopulationInitialization<T> initialization;
    boolean minimize;

    public abstract void apply();


}
