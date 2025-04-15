package com.wiser.figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFigureInput {
    private FigureFactoryConsole figureFactoryConsole = new FigureFactoryConsole();



    @Test
    public void test(){
        figureFactoryConsole.takeInput();
        assertEquals(1,1);
    }

//    @Test
//    public void test(){
//
//        assertEquals(1,1);
//    }
//
//    @Test
//    public void test(){
//
//        assertEquals(1,1);
//    }
//
//    @Test
//    public void test(){
//
//        assertEquals(1,1);
//    }
//
//    @Test
//    public void test(){
//
//        assertEquals(1,1);
//    }
}
