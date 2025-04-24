package com.wiser.figures;

import com.wiser.figures.figuresClasses.Circle;
import com.wiser.figures.figuresClasses.Rectangle;
import com.wiser.figures.figuresClasses.Triangle;
import com.wiser.figures.figuresClasses.figuresClasses;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class StringToFigure {
    Figure createFrom(String representation) {
        try (Scanner scanner = new Scanner(representation)) {

            if (!scanner.hasNext()) {
                throw new IllegalArgumentException("empty figure representation");
            }

            String figureType = scanner.next();
            //Transforms tRiAnglE to Triangle
            figureType = figureType.substring(0,1).toUpperCase() + figureType.substring(1).toLowerCase(Locale.ROOT);

            //checks if it maches any enums of figuresClasses
            if(!isCorrectFigure(figureType)){
                throw new IllegalArgumentException("unknown figure type: " + figureType);
            }

            Class<?> figureClass = Class.forName("com.wiser.figures.figuresClasses."+ figureType);
            Constructor<?>[] constructors = figureClass.getDeclaredConstructors();
            int fields = figureClass.getDeclaredFields().length;

            //find the constructor with all arguments
            Constructor<?> allArgsConstructor = constructors[0];

            for (Constructor<?> constructor: constructors){
                if(fields == constructor.getParameterCount()){
                    allArgsConstructor = constructor;
                }
            }

            //take input for the fields
            double[] args = new double[fields];
            for (int i = 0; i < fields; i++) {
                if (scanner.hasNextDouble()) {
                    args[i] = scanner.nextDouble();
                } else {
                    throw new IllegalArgumentException(
                            "creation of " +figureType +" requires " + fields + " double values.\n" +
                                    "missing or incorrect argument at position: " + (i + 1)
                    );
                }
            }

            //this is like new Rectangle(args[0], args[1])
            return (Figure) allArgsConstructor.newInstance(Arrays.stream(args).boxed().toArray(Double[]::new));

        } catch (Exception e) {
            throw new IllegalArgumentException("error parsing figure: " + e.getMessage());
        }

    }

    private boolean isCorrectFigure(String figureType) {
        if(Arrays.stream(figuresClasses.values()).anyMatch(s -> s.name().equals(figureType))){
            return true;
        }
        return  false;
    }

//version without reflection
// Figure createFrom(String representation) {
//        try (Scanner scanner = new Scanner(representation)) {
//
//            if (!scanner.hasNext()) {
//                throw new IllegalArgumentException("empty figure representation");
//            }
//
//            String figureType = scanner.next();
//
//            if (figureType.equalsIgnoreCase("triangle")) {
//                double[] triangleSides = new double[3];
//                for (int i = 0; i < 3; i++) {
//                    if (scanner.hasNextDouble()) {
//                        triangleSides[i] = scanner.nextDouble();
//                    } else {
//                        throw new IllegalArgumentException(
//                                "creation of triangle requires 3 double values.\n" +
//                                        "missing or incorrect argument at position: " + (i + 1)
//                        );
//                    }
//                }
//                return new Triangle(triangleSides[0], triangleSides[1], triangleSides[2]);
//
//            } else if (figureType.equalsIgnoreCase("circle")) {
//                if (scanner.hasNextDouble()) {
//                    double radius = scanner.nextDouble();
//                    return new Circle(radius);
//                } else {
//                    throw new IllegalArgumentException(
//                            "creation of circle requires 1 double value.\n" +
//                                    "missing or incorrect radius."
//                    );
//                }
//
//
//            } else if (figureType.equalsIgnoreCase("rectangle")) {
//                double[] rectangleSides = new double[2];
//                for (int i = 0; i < 2; i++) {
//                    if (scanner.hasNextDouble()) {
//                        rectangleSides[i] = scanner.nextDouble();
//                    } else {
//                        throw new IllegalArgumentException(
//                                "creation of rectangle requires 2 double values.\n" +
//                                        "missing or incorrect argument at position: " + (i + 1)
//                        );
//                    }
//                }
//                return new Rectangle(rectangleSides[0], rectangleSides[1]);
//
//            } else {
//                throw new IllegalArgumentException("unknown figure type: " + figureType);
//            }
//
//        } catch (Exception e) {
//            throw new IllegalArgumentException("error parsing figure: " + e.getMessage());
//        }
//    }
}
