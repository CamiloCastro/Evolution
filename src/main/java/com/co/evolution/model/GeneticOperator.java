package com.co.evolution.model;

import java.util.List;

public interface GeneticOperator<T> {

    List<Individual<T>> apply(List<T> individuals);

}
