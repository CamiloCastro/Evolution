package com.co.evolution.model;

import java.util.List;

public interface SelectionMethod<T> {

    void init(List<Individual<T>> individuals);

    Individual<T> select(List<Individual<T>> individuals);

}
