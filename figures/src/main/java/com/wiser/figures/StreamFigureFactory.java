package com.wiser.figures;

import java.io.InputStream;
import java.util.Scanner;


//TODO fix return
public class StreamFigureFactory implements FigureFactory {

    private final Scanner scanner;
    private final StringToFigure stringToFigure;

    public StreamFigureFactory(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
        this.stringToFigure = new StringToFigure();
    }

    @Override
    public Figure create() {
            if (scanner.hasNextLine()) {
                String figureAsString = scanner.nextLine();
                return stringToFigure.createFrom(figureAsString);
            }
            else {
                throw new RuntimeException("No more figures in the stream");
            }
    }

    public void close(){
        scanner.close();
    }
}
