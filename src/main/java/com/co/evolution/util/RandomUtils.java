package com.co.evolution.util;

import java.util.HashSet;
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

    public static int nextInt(int max)
    {
        Random rnd = new Random();
        return rnd.nextInt(max);
    }

    public static HashSet<Integer> getDifferentRandomIntegers(int max, int size)
    {
        HashSet<Integer> hs =  new HashSet<>();
        while (hs.size() < size)
        {
            hs.add(nextInt(max));
        }
        return hs;
    }



}
