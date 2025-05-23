package com.wiser.figures.figuresClasses;

import com.wiser.figures.Figure;

public class Circle implements Figure{

    private final double radius;

    public Circle(double radius) {
        if(radius<=0){
            throw new IllegalArgumentException("Radius value must be positive");
        }

        if(Double.isInfinite(2*Math.PI*radius)){
            throw new ArithmeticException("Calculating parameter will cause overflow");
        }

        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString(){
        return "circle "+radius;
    }

    @Override
    public Figure clone(){
        return new Circle(this.radius);
    }

    public double getRadius() {
        return radius;
    }
}
