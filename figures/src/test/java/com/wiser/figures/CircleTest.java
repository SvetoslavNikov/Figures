package com.wiser.figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    @Test
    public void testCircleConstructorNegativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> {
            Circle circle = new Circle(-5);
        });
    }

    @Test
    public void testCircleConstructorZeroRadius() {
        assertThrows(IllegalArgumentException.class, () -> {
            Circle circle = new Circle(0);
        });
    }

    @Test
    public void testCircleConstructorDoubleOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            Circle circle = new Circle(Double.MAX_VALUE);
        });
    }

    @Test
    public void testPerimeter() {
        Circle circle = new Circle(2);
        assertEquals(2 * Math.PI * 2, circle.perimeter(), 0.001);

        circle = new Circle(0.01);
        assertEquals(2 * Math.PI * 0.01, circle.perimeter(), 0.001);
    }


    @Test
    public void testToStringMethod() {
        Circle circle = new Circle(5);
        String expected = "circle 5.0";
        assertEquals(expected, circle.toString());
    }

    @Test
    public void testCloneMethodCreatesNewInstanceOfCircle() throws CloneNotSupportedException {
        Circle circle = new Circle(5);
        Object obj = circle.clone();
        assertInstanceOf(Circle.class, obj);
        assertNotSame(circle, obj);
    }

    @Test
    public void testCloneMethodSetsSameProperties() throws CloneNotSupportedException {
        Circle circle = new Circle(5);
        Circle copy = (Circle) circle.clone();
        assertEquals(circle.getRadius(), copy.getRadius(), 0.0001);
    }

    @Test
    public void testGetter() {
        Circle circle = new Circle(4.5);
        assertEquals(4.5, circle.getRadius(), 0.0001);
    }
}
