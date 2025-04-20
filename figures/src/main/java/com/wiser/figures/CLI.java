package com.wiser.figures;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//CLI is not finished

public class CLI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Figure> figureList = new ArrayList<>();

    public static void startCLI() {
        System.out.println("\nWelcome to Figuro\n" +
                "The app that helps you create geometrical shapes and calculate their parameters :)\n");


        boolean CLIrunning = true;
        while (CLIrunning) {
            //success or failure of each command will lead to this main menu
            printMainMenu();
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "create":
                    createFigures();
                    break;
                case "ls":
                    printFiguresList();
                    break;
                case "delete":
                    //deleteFigure();
                    break;
                case "save":
                    //saveFiguresListToFile();
                    break;
                case "exit":
                    System.out.println("thank you for using Figure, bye!");
                    break;
                default:
                    System.out.println("unknown command. please choose command from the menu.");
            }
        }
    }


    private static void printMainMenu() {
        System.out.println("\nmain menu:");
        System.out.println("> create");
        System.out.println("> ls");
        System.out.println("> delete");
        System.out.println("> duplicate");
        System.out.println("> save");
        System.out.println("> exit");
        System.out.print("\nenter command: ");
    }

    //TODO: finish the method

    private static void createFigures() {
        System.out.println("\nChoose a method for creating figures:");
        System.out.println("> random");
        System.out.println("> stdin");
        System.out.println("> file");
        System.out.print("\nenter method: ");

        String chosenMethod = scanner.nextLine().toLowerCase().trim();
        FigureFactory factory = createFactoryForMethod(chosenMethod);
        if (factory == null) {
            System.out.println("invalid creation method. returning to main menu.");
            return;
        }

        System.out.print("how many figures do you want to create? ");
        int count = 0;
        try {
            count = Integer.parseInt(scanner.nextLine().trim());
            if (count <= 0) {
                System.out.println("number must be positive. returning to main menu.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("invalid number. returning to main menu.");
            return;
        }

        // Create the figures
        for (int i = 0; i < count; i++) {
            try {
                Figure figure = factory.create();
                if (figure != null) {
                    figureList.add(figure);
                    System.out.println("created: " + figure);
                }
            } catch (RuntimeException e) {
                System.out.println("error creating figure: " + e.getMessage());
                System.out.print("continue creating figures? (y/n): ");
                if (!scanner.nextLine().trim().toLowerCase().startsWith("y")) {
                    break;
                }
            }
        }

        if (factory instanceof StreamFigureFactory) {
            ((StreamFigureFactory) factory).close();
        }

        System.out.println("created " + figureList.size() + " figures.");
    }

    private static FigureFactory createFactoryForMethod(String method) {
        switch (method) {
            case "random":
                return new RandomFigureFactory();

            case "stdin":
                System.out.println(instructionsForStdinInput());
                System.out.println("enter figures (one per line):");
                return new StreamFigureFactory(System.in);

            case "file":
                return createFileFactory();

            default:
                System.out.println("unknown creation method: " + method);
                return null;
        }
    }

    private static FigureFactory createFileFactory() {
        System.out.print("enter file path: ");
        String filePath = scanner.nextLine().trim();

        try {
            Path path = Paths.get(filePath);
            InputStream inputStream = Files.newInputStream(path);
            return new StreamFigureFactory(inputStream);
        } catch (Exception e) {
            System.out.println("error opening file: " + e.getMessage());
            return null;
        }
    }

    private static void deleteFigure() {
        if (figureList.isEmpty()) {
            System.out.println("no figures to delete.");
            return;
        }

        printFiguresList();
        System.out.print("enter the number of the figure to delete: ");

        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (index >= 0 && index < figureList.size()) {
                Figure removed = figureList.remove(index);
                System.out.println("deleted: " + removed);
            } else {
                System.out.println("invalid figure number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("invalid input. please enter a number.");
        }
    }

    private static void duplicateFigure() {
        if (figureList.isEmpty()) {
            System.out.println("no figures to duplicate.");
            return;
        }

        printFiguresList();
        System.out.print("enter the number of the figure to duplicate: ");

        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (index >= 0 && index < figureList.size()) {
                Figure original = figureList.get(index);
                Figure copy = original.clone();
                figureList.add(copy);
                System.out.println("duplicated: " + original);
            } else {
                System.out.println("invalid figure number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("invalid input. please enter a number.");
        }
    }

    private static void saveFiguresToFile() {
        if (figureList.isEmpty()) {
            System.out.println("no figures to save.");
            return;
        }

        System.out.print("enter file path to save figures: ");
        String filePath = scanner.nextLine().trim();

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Figure figure : figureList) {
                writer.println(figure.toString());
            }
            System.out.println("figures saved to " + filePath);
        } catch (IOException e) {
            System.out.println("error saving to file: " + e.getMessage());
        }
    }

    public static String instructionsForStdinInput() {
    StringBuilder sb = new StringBuilder();
    sb.append("> Ok, create a shape\n");
    sb.append("> Type figure type + measurements\n");
    sb.append("> Just like in the following examples:\n\n");

    sb.append("   /\\   \n");
    sb.append("  /  \\  \n");
    sb.append(" /____\\\n");
    sb.append("triangle 20.1 20.2 20.3\n\n");

    sb.append("  ****  \n");
    sb.append(" *    * \n");
    sb.append("  ****  \n");
    sb.append("circle 5.5\n\n");

    sb.append(" +----+ \n");
    sb.append(" |    | \n");
    sb.append(" +----+ \n");
    sb.append("rectangle 10.1 20.2\n");

    sb.append("Enter figures (one per line):");

    return sb.toString();
}

private static void printFiguresList() {
    if (figureList.isEmpty()) {
        System.out.println("there are no figures to display.");
        return;
    }

    StringToFigure stringToFigure = new StringToFigure();
    for (int i = 0; i < figureList.size(); i++) {
        System.out.println(i + ". - " + figureList.get(i).toString());
    }
}

}

