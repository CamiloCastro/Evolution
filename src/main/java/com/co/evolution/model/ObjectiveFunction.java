package com.co.evolution.model;

public interface ObjectiveFunction<T> {

    double apply(T individual);

}
