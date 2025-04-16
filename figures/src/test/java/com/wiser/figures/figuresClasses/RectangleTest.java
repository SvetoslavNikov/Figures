package com.wiser.figures.figuresClasses;

import com.wiser.figures.figuresClasses.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {

    @Test
    public void testRectangleConstructorNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rect = new Rectangle(-2, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rect = new Rectangle(2, -5);
        });
    }

    @Test
    public void testRectangleConstructorZeroSides() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rect = new Rectangle(0, 5);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rect = new Rectangle(5, 0);
        });
    }

    @Test
    public void testRectangleConstructorDoubleOverflow() {
        assertThrows(ArithmeticException.class, () -> {
            Rectangle rect = new Rectangle(Double.MAX_VALUE, Double.MAX_VALUE);
        });
    }

    @Test
    public void testPerimeter() {
        Rectangle rect = new Rectangle(2, 3);
        assertEquals(2 * (2 + 3), rect.perimeter(), 0.001);

        rect = new Rectangle(0.5, 1.5);
        assertEquals(2 * (0.5 + 1.5), rect.perimeter(), 0.001);
    }


    @Test
    public void testToStringMethod() {
        Rectangle rect = new Rectangle(3, 4);
        String expected = "rectangle 3.0 4.0";
        assertEquals(expected, rect.toString());
    }

    @Test
    public void testCloneMethodCreatesNewInstanceOfRectangle() throws CloneNotSupportedException {
        Rectangle rect = new Rectangle(3, 4);
        Object obj = rect.clone();
        assertInstanceOf(Rectangle.class, obj);
        assertNotSame(rect, obj);
    }

    @Test
    public void testCloneMethodSetsSameProperties() throws CloneNotSupportedException {
        Rectangle rect = new Rectangle(3, 4);
        Rectangle copy = (Rectangle) rect.clone();
        assertEquals(rect.getSideA(), copy.getSideA(), 0.0001);
        assertEquals(rect.getSideB(), copy.getSideB(), 0.0001);
        assertEquals(rect.perimeter(), copy.perimeter(), 0.0001);

    }

    @Test
    public void testGetters() {
        Rectangle rect = new Rectangle(6, 7);
        assertEquals(6, rect.getSideA(), 0.0001);
        assertEquals(7, rect.getSideB(), 0.0001);
    }
}
