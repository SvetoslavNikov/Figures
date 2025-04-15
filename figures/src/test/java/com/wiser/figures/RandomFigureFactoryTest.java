package com.wiser.figures;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomFigureFactoryTest {
    private static RandomFigureFactory randomFigureFactory;

    @BeforeAll
    public static void setRandomFigureFactory(){
        randomFigureFactory = new RandomFigureFactory();
    }

    @Test
    public void testCreateMethod(){
        Object obj = randomFigureFactory.create();
        assertNotNull(obj);
        assertInstanceOf(Figure.class, obj);
    }
}
