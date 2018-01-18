package com.co.evolution.model;

import java.util.List;

public interface PopulationInitialization<T> {

    List<Individual<T>> init();

}
