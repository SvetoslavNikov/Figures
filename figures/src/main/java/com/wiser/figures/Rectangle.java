package com.wiser.figures;

public class Rectangle implements Figure,Cloneable{
    private final double sideA;
    private final double sideB;

    public Rectangle(double sideA, double sideB) {
        if(sideA<=0 || sideB <= 0){
            throw new IllegalArgumentException("All values must be positive");
        }

        if(Double.isInfinite(sideA+sideB)){
            throw new ArithmeticException("Calculating parameter will cause overflow");
        }

        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double perimeter() {
        return 2*(sideA+sideB);
    }

    @Override
    public String toString(){
        return "rectangle "+ sideA + " " + sideB ;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Rectangle(this.getSideA(), this.getSideB());
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }
}
