package com.co.evolution.model;

import lombok.Data;

import java.util.List;

@Data
public abstract class GeneticOperator<T> {

    int cardinal;

    public abstract List<T> apply(List<T> individuals);

}
