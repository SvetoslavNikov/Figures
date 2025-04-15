package com.wiser.figures;

import java.util.Scanner;

public class StringToFigure {

    Figure createFrom(String representation) {
        try (Scanner scanner = new Scanner(representation)) {

            if (!scanner.hasNext()) {
                throw new IllegalArgumentException("empty figure representation");
            }

            String figureType = scanner.next();

            if (figureType.equalsIgnoreCase("triangle")) {
                double[] triangleSides = new double[3];
                for (int i = 0; i < 3; i++) {
                    if (scanner.hasNextDouble()) {
                        triangleSides[i] = scanner.nextDouble();
                    } else {
                        throw new IllegalArgumentException(
                                "creation of triangle requires 3 double values.\n" +
                                        "missing or incorrect argument at position: " + (i + 1)
                        );
                    }
                }
                return new Triangle(triangleSides[0], triangleSides[1], triangleSides[2]);

            } else if (figureType.equalsIgnoreCase("circle")) {
                if (scanner.hasNextDouble()) {
                    double radius = scanner.nextDouble();
                    return new Circle(radius);
                } else {
                    throw new IllegalArgumentException(
                            "creation of circle requires 1 double value.\n" +
                                    "missing or incorrect radius."
                    );
                }

            } else if (figureType.equalsIgnoreCase("rectangle")) {
                double[] rectangleSides = new double[2];
                for (int i = 0; i < 2; i++) {
                    if (scanner.hasNextDouble()) {
                        rectangleSides[i] = scanner.nextDouble();
                    } else {
                        throw new IllegalArgumentException(
                                "creation of rectangle requires 2 double values.\n" +
                                        "missing or incorrect argument at position: " + (i + 1)
                        );
                    }
                }
                return new Rectangle(rectangleSides[0], rectangleSides[1]);

            } else {
                throw new IllegalArgumentException("unknown figure type: " + figureType);
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("error parsing figure: " + e.getMessage());
        }
    }
}
