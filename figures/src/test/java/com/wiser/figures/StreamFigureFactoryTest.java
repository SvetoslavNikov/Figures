package com.wiser.figures;

import com.wiser.figures.figuresClasses.Circle;
import com.wiser.figures.figuresClasses.Rectangle;
import com.wiser.figures.figuresClasses.Triangle;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class StreamFigureFactoryTest {

    //incorrect/empty inputs are covered in the StringToFigureTest

    @Test
    public void testFigureCreationOfStream() {
        StreamFigureFactory factory = factoryFrom("triangle 10 20 20\n" +
                "triangle 1 2 2\n" +
                "rectangle 2 2\n"+
                "circle 2.2");

        assertInstanceOf(Triangle.class, factory.create());
        assertInstanceOf(Triangle.class, factory.create());
        assertInstanceOf(Rectangle.class, factory.create());
        assertInstanceOf(Circle.class, factory.create());
        assertThrows(RuntimeException.class, factory::create);
    }

    private StreamFigureFactory factoryFrom(String input) {
        return new StreamFigureFactory(
                new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))
        );
    }
}
