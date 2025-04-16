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
        FigureFactory figureFactory = createFactoryForChosenMethod(chosenMethod);

        if (figureFactory == null) {
            System.out.println("invalid method, returning to the main menu");
            return;
        }
        //...
        return;
    }

    //TODO: finish the method
    public static FigureFactory createFactoryForChosenMethod(String chosenMethod) {
        if (chosenMethod.isEmpty()) {
            return null;
        }

        if (chosenMethod.equals("random")) {
            return new RandomFigureFactory();
        }

        if (chosenMethod.equals("stdin")) {
            System.out.println(instructionsForStdinInput());

        }

        if (chosenMethod.equals("file")) {

        }

        return null;
    }


    public static String instructionsForStdinInput() {
        StringBuilder sb = new StringBuilder();
        sb.append("> Ok, create a shape\n");
        sb.append("> Type figure type + measurements, each on a new line\n");
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

        return sb.toString();
    }

    private static void printFiguresList() {
        if(figureList.isEmpty()){
            System.out.println("there are no figures to display.");
            return;
        }

        StringToFigure stringToFigure = new StringToFigure();
        for (int i = 0; i < figureList.size(); i++) {
            System.out.println(i + ". - "+ figureList.get(i).toString());
        }
    }

    //TODO: finish other methods


}

