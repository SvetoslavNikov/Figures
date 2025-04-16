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
                    //createFigures();
                    break;
                case "ls":
                    //printFiguresList();
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

}
