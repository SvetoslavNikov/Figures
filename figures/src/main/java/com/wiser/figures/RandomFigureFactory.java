package com.wiser.figures;

import java.util.Random;

public class RandomFigureFactory implements FigureFactory{
    private static final double MAX_VALUE = 1000.0;

    @Override
    public Figure create() {
        Figure figure;

        Random rand = new Random();
        String[] figureType = {"triangle", "circle", "rectangle"};
        int chosenType = rand.nextInt(3);
        String chosenFigure = figureType[chosenType];

        switch (chosenFigure) {
            case "triangle" -> {
                double sideA, sideB, sideC;
                do {
                    sideA = rand.nextDouble()*MAX_VALUE;
                    sideB = rand.nextDouble()*MAX_VALUE;
                    sideC = rand.nextDouble()*MAX_VALUE;
                } while (!(sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA));

                figure = new Triangle(sideA, sideB, sideC);
            }
            case "circle" -> {
                double radius = rand.nextDouble()*MAX_VALUE;
                figure = new Circle(radius);
            }
            case "rectangle" -> {
                double sideA = rand.nextDouble()*MAX_VALUE;
                double sideB = rand.nextDouble()*MAX_VALUE;
                figure = new Rectangle(sideA, sideB);
            }
            default -> throw new IllegalStateException("unexpected value : " + chosenFigure + "\nfix switch-cases");
        }

        return figure;
    }

    public static double getMaxValue() {
        return MAX_VALUE;
    }


}
