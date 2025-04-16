package com.wiser.figures;

import com.wiser.figures.figuresClasses.Circle;
import com.wiser.figures.figuresClasses.Rectangle;
import com.wiser.figures.figuresClasses.Triangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RandomFigureFactoryTest {
    private static RandomFigureFactory randomFigureFactory;

    @BeforeAll
    public static void setRandomFigureFactory() {
        randomFigureFactory = new RandomFigureFactory();
    }

    private List<Figure> generateRandomFigures(int count) {
        List<Figure> figures = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            figures.add(randomFigureFactory.create());
        }
        return figures;
    }

    @Test
    public void testCreateMethod() {
        Object obj = randomFigureFactory.create();
        assertNotNull(obj);
        assertInstanceOf(Figure.class, obj);
    }

    @Test
    public void testDistribution() {
        int n = 900;
        List<Figure> figures = generateRandomFigures(n);

        int triangles = 0, circles = 0, rectangles = 0;

        for (Figure figure : figures) {
            if (figure instanceof Triangle) triangles++;
            else if (figure instanceof Circle) circles++;
            else if (figure instanceof Rectangle) rectangles++;
            else {
                fail("unknown figure type " +
                        "Add tests for the new figures you have added!");
            }
        }


        double expectedInstancesPerType = n / 3.0;
        double minInstancesPerType = expectedInstancesPerType * 0.2;

        assertTrue(triangles - expectedInstancesPerType < minInstancesPerType,
                "triangle count not within expected range");
        assertTrue(circles - expectedInstancesPerType < minInstancesPerType,
                "circle count not within expected range");
        assertTrue(rectangles - expectedInstancesPerType < minInstancesPerType,
                "rectangle count not within expected range");
    }

    @Test
    public void testRandomValueRanges() {
        int n = 300;
        List<Figure> figures = generateRandomFigures(n);

        double maxValue = RandomFigureFactory.getMaxValue();

        for (Figure figure : figures) {
            if (figure instanceof Triangle triangle) {
                assertTrue(triangle.getSideA() >= 0 && triangle.getSideA() <= maxValue);
                assertTrue(triangle.getSideB() >= 0 && triangle.getSideB() <= maxValue);
                assertTrue(triangle.getSideC() >= 0 && triangle.getSideC() <= maxValue);
            } else if (figure instanceof Circle circle) {
                assertTrue(circle.getRadius() >= 0 && circle.getRadius() <= maxValue);
            } else if (figure instanceof Rectangle rectangle) {
                assertTrue(rectangle.getSideA() >= 0 && rectangle.getSideA() <= maxValue);
                assertTrue(rectangle.getSideB() >= 0 && rectangle.getSideB() <= maxValue);
            } else {
                fail("unknown figure type " +
                        "Add tests for the new figures you have added!");
            }
        }
    }

}
