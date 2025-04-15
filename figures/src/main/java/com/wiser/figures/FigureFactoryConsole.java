//package com.wiser.figures;
//
//
//import java.util.*;
//
//public class FigureFactoryConsole implements FigureFactory {
//
//    //assuming string s is in format figure sideA sideB sideC
//    @Override
//    public Figure createFigure(String s) {
//        List<String> ls = Arrays.stream(s.split(" ")).toList();
//        String figureType = ls.get(0);
//        Figure figure = null;
//
//        if (figureType.equalsIgnoreCase("triangle")) {
//            double sideA = Double.parseDouble(ls.get(1));
//            double sideB = Double.parseDouble(ls.get(2));
//            double sideC = Double.parseDouble(ls.get(3));
//            figure = new Triangle(sideA, sideB, sideC);
//
//        } else if (figureType.equalsIgnoreCase("circle")) {
//            double radius = Double.parseDouble(ls.get(1));
//            figure = new Circle(radius);
//
//        } else if (figureType.equalsIgnoreCase("rectangle")) {
//            double sideA = Double.parseDouble(ls.get(1));
//            double sideB = Double.parseDouble(ls.get(2));
//            figure = new Rectangle(sideA,sideB);
//
//        } else {
//            System.out.println("sorry wrong figure wtf");
//        }
//
//        return figure;
//    }
//
//    public String takeInput(){
//        Scanner scanner = new Scanner(System.in);
//        String input = null;
//
//        return input;
//    }
//
//}
//
