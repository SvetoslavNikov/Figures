package com.wiser.figures;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            Path path = Path.of(scanner.nextLine());
        }catch(InvalidPathException e){
            System.out.println(e.getMessage());
        }




    }
}
