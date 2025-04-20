package com.wiser.figures.figuresClasses;

import com.wiser.figures.Figure;

public class Triangle implements Figure{

    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {

        if (sideA < 0 || sideB < 0 || sideC < 0) {
            throw new IllegalArgumentException("All values must be positive");
        }

        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Every side should be less then the sum of the other two!");
        }

        if(Double.isInfinite(sideA+sideB+sideC)){
            throw new ArithmeticException("Calculating parameter will cause overflow");
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }


    @Override
    public String toString() {
        return "triangle " + sideA + " " + sideB + " " + sideC;
    }

    @Override
    public Figure clone(){
        return new Triangle(this.getSideA(),this.getSideB(),this.getSideC());
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

}

