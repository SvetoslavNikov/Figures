package com.wiser.figures.tests;

public class DoubleExample {
    public static void main(String[] args) {
        double max = Double.MAX_VALUE;
        double min = Double.MIN_VALUE;
        double inf = Double.POSITIVE_INFINITY;

        System.out.println("Double max: " + max);
        System.out.println();
        System.out.println("Double min: " + min);
        System.out.println();
        System.out.println("Double inf: " + inf);

        double sum = max + 1e308;
        double sum1 = max + 10;
        System.out.println("overflow sum: " + sum);

        System.out.println("overflow sum1 : " + sum1);
        System.out.println("is infinity? " + Double.isInfinite(sum));
        System.out.println("is infinity? " + Double.isInfinite(sum1));
    }
}
