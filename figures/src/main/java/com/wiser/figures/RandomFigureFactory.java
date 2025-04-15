//package com.wiser.figures;
//
//import java.util.Random;
//
//public class RandomFigureFactory implements FigureFactory{
//
//    @Override
//    public Figure create() {
//        Figure figure = null;
//
//        Random rand = new Random();
//        int figureType  = rand.nextInt(3);
//        //triangle - 0
//        //circle - 1
//        //rectangle - 2
//
//            if (figureType == 0) {
//                double sideA, sideB, sideC;
//                do {
//                    sideA = rand.nextInt(100) * Math.random();
//                    sideB = rand.nextInt(100) * Math.random();
//                    sideC = rand.nextInt(100) * Math.random();
//                } while (!(sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA));
//
//                figure = new Triangle(sideA, sideB, sideC);
//
//            } else if (figureType == 1) {
//                double radius = rand.nextInt(100) * Math.random();
//                figure = new Circle(radius);
//
//            } else if (figureType == 2) {
//                double sideA = rand.nextInt(100) * Math.random();
//                double sideB = rand.nextInt(100) * Math.random();
//                figure = new Rectangle(sideA,sideB);
//            }
//
//        return figure;
//    }
//}
