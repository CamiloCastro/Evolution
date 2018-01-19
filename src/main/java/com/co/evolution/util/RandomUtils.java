package com.co.evolution.util;

import java.util.Random;

public class RandomUtils {

    public static double nextDouble(double min, double max)
    {
        Random rnd = new Random();
        return (rnd.nextDouble() * (max - min)) + min;
    }

    public static double nextGaussian(double sigma, double mean)
    {
        Random rnd = new Random();
        return sigma * rnd.nextGaussian() + mean;
    }



}
