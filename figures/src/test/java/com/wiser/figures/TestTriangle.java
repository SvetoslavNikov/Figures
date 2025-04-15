package com.wiser.figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTriangle {
//TODO: Boundary Tests: Test for very small (close to zero) and large values to see if the class handles them correctly.
//
//TODO: Edge Cases: For instance, testing a triangle with very close-to-equal sides to check if the perimeter calculation is accurate.

//TODO: add throwing exceptions or somethign when user inputs under the precision?
//TODO: SETUP A REPO AND COMMIT thoruh git bash

    // //too small numbers?
    //        //too big numbers?
    //        //overflow?
    //        //precision?


    @Test
    public void testTriangleConstructorWrongSizes() {
        //one side size equal to the sum of the other two

        //wrong sideA
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(4, 2, 2);
        });

        //wrong sideB
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(2, 4, 2);
        });

        //wrong sideC
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(2, 2, 4);
        });
    }

    @Test
    public void testTriangleConstructorNegativeNums() {
        //negative num input
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(-2, 2, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(2, -2, 4);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(2, 2, -4);
        });
    }

    @Test
    public void testTriangleConstructorDoubleOverflow(){
        assertThrows(ArithmeticException.class, () -> {
            Triangle triangle = new Triangle(Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE);
        });
        assertThrows(ArithmeticException.class, () -> {
            Triangle triangle = new Triangle(Double.MAX_VALUE,Double.MAX_VALUE,1);
        });
    }

    @Test
    public void testTrianglePerimeterMethod() {
        Triangle triangle = new Triangle(1.001, 2.11, 2.12);

        assertEquals(5, triangle.perimeter(),0.0001);
    }

    @Test
    public void testToStringMethod() {
        Triangle triangle = new Triangle(1, 2, 2);
        String expected = "triangle 1 2 2";

        assertEquals(expected, triangle.toString());
    }

    @Test
    public void testCloneMethodCreatesNewInstanceOfTriangle() throws CloneNotSupportedException {
        Triangle triangle = new Triangle(1, 2, 2);

        Object obj = triangle.clone();
        assertInstanceOf(Triangle.class, obj);

        Triangle triangleCopy = (Triangle) obj;
        assertNotSame(triangleCopy, triangle);
    }

    @Test
    public void testCloneMethodSetsSameProperties() throws CloneNotSupportedException {
        Triangle triangle = new Triangle(1, 2, 2);
        Triangle triangleCopy = (Triangle) triangle.clone();

        assertEquals(triangle.getSideA(), triangleCopy.getSideA(),0.0001);
        assertEquals(triangle.getSideB(), triangleCopy.getSideB(),0.0001);
        assertEquals(triangle.getSideC(), triangleCopy.getSideC(),0.0001);

        assertEquals(triangle.perimeter(), triangleCopy.perimeter(),0.0001);
    }

    @Test
    public void testGetters() {
        Triangle triangle = new Triangle(2, 4, 5);

        assertEquals(2, triangle.getSideA(),0.0001);
        assertEquals(4, triangle.getSideB(),0.0001);
        assertEquals(5, triangle.getSideC(),0.0001);
    }
}
