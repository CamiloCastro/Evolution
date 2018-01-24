package com.co.evolution.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public abstract class FitnessCalculation<T> {

    List<ObjectiveFunction<T>> objectiveFunctions;

    public abstract double calculate(T individual, List<T> population);

}
