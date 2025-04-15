package com.wiser.figures;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestStringToFigure {

    //cases for negative nums, incorrect sizes and overflow
    //are covered in the tests for each object's constructor

    private static StringToFigure stringToFigure;

    @BeforeAll
    public static void setStringToFigure(){
        stringToFigure = new StringToFigure();
    }

    private void expectInvalidInput(String input){
        assertThrows(IllegalArgumentException.class,() -> {
            stringToFigure.createFrom(input);
        });
    }

    //negative tests
    @Test
    public void testMissingArgument() {
        expectInvalidInput("triangle");
        expectInvalidInput("triangle 20");
        expectInvalidInput("triangle 10 20");
        expectInvalidInput("circle");
        expectInvalidInput("rectangle");
        expectInvalidInput("rectangle 20");
    }

    @Test
    public void testIncorrectArgument() {
        expectInvalidInput("triangle abc 20 20");
        expectInvalidInput("triangle 10 abc 20");
        expectInvalidInput("triangle 10 20 abc");
        expectInvalidInput("circle abc");
        expectInvalidInput("rectangle abc 20");
        expectInvalidInput("rectangle 20 abc");
    }

    @Test
    public void testIncorrectFigureType(){
        expectInvalidInput("unknownType 2.33 2.22 2.22");
        expectInvalidInput("pentatope 10");
        expectInvalidInput("tesseract 10 20 20");
    }

    @Test
    public void testTotallyWrongInput(){
        expectInvalidInput("Was there anything before the Big Bang?");

    }

    //positive tests :)
    @Test
    public void testReturnsTriangle(){
        Figure figure = stringToFigure.createFrom("triangle 10 20 20");
        assertInstanceOf(Triangle.class,figure);
    }


    @Test
    public void testReturnsCircle(){
        Figure figure = stringToFigure.createFrom("circle 10");
        assertInstanceOf(Circle.class,figure);
    }

    @Test
    public void testReturnsRectangle(){
        Figure figure = stringToFigure.createFrom("rectangle 10 20");
        assertInstanceOf(Rectangle.class,figure);
    }
}
