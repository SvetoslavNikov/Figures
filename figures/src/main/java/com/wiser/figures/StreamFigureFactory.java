//package com.wiser.figures;
//
//import java.io.InputStream;
//import java.util.Scanner;
//import java.util.stream.Stream;
//
//public class StreamFigureFactory implements FigureFactory {
//
//    private Stream<String> stream;
//    public StreamFigureFactory(Stream<String> stream) {
//        this.stream = stream;
//    }
//
//    @Override
//    public Figure create() {
//        Scanner scanner = new Scanner((InputStream) stream);
//        String figureType  = scanner.next();
//
//        Figure figure = null;
//
//        if (figureType.equalsIgnoreCase("triangle")) {
//            double sideA = scanner.nextDouble();
//            double sideB = scanner.nextDouble();
//            double sideC = scanner.nextDouble();
//            figure = new Triangle(sideA, sideB, sideC);
//
//        } else if (figureType.equalsIgnoreCase("circle")) {
//            double radius = scanner.nextDouble();
//            figure = new Circle(radius);
//
//        } else if (figureType.equalsIgnoreCase("rectangle")) {
//            double sideA = scanner.nextDouble();;
//            double sideB = scanner.nextDouble();
//            figure = new Rectangle(sideA,sideB);
//
//        } else {
//            System.out.println("sorry wrong figure wtf");
//        }
//
//        return figure;
//    }
//}
//
///*
//Create a StreamFigureFactory class, which creates figures from a stream. Make it so
//that it receives a stream in its constructor. Every time a figure needs to be created, it
//should attempt to read the data for it from the stream. A simple way to implement this is
//to read a line of text from the stream and then pass it to the string-to-figure factory that
//you have already created.
//
//• You can use the stream factory to read a sequence of figures either from STDIN, or
//from a file
// */