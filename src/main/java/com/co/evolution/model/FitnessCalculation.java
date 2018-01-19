package com.co.evolution.model;

import lombok.Data;

import java.util.List;

@Data
public abstract class FitnessCalculation<T> {

    List<ObjectiveFunction<T>> objectiveFunctions;

    public abstract double moCalculate(List<T> individuals);

    public abstract double calculate(T individuals);

}
