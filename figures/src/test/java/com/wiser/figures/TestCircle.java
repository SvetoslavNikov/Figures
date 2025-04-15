package com.wiser.figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCircle {

    @Test
    public void testCircleIllegalArgs(){
        assertThrows(IllegalArgumentException.class,() -> {
            Circle circle = new Circle(-4);
        });

        assertThrows(IllegalArgumentException.class,() -> {
            Circle circle = new Circle(0);
        });
    }

    @Test
    public void testPeramiter(){
        Circle circle = new Circle(2);
        assertEquals(2*Math.PI*2, circle.perimeter(),0.001);
        
        circle = new Circle(0.01);
        assertEquals(2*Math.PI*0.01, circle.perimeter(),0.001);
    }


    @Test
    public void testToString(){
        Circle circle = new Circle(2.2);
        String expected = "circle 2.2";
        assertEquals(expected, circle.toString());
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        Circle circle = new Circle(2.2);

        Circle circleCopy = (Circle) circle.clone();

        //instance
        assertNotSame(circleCopy, circle);
        //fields
        assertEquals(circle.getRadius(), circleCopy.getRadius());
        //methods
        assertEquals(circle.perimeter(), circleCopy.perimeter());

    }
}
