package com.wiser.figures;

//Here I store some parts of first versions of cli
//don't read it
public class CLIspareParts {

//
//         public static String instructionsForStdinInput() {
////        String message =
////                ">Ok create a shape\n" +
////                ">Type figure type + measurements, each on a new line\n" +
////                ">Just like in the fallowing examples: \n\n";
////        String triangle =
////                        "   /\\   \n" +
////                        "  /  \\  \n" +
////                        " /____\\\n" +
////                        "create triangle a b c\n";
////
////        String circle =
////                        "  ****  \n" +
////                        " *    * \n" +
////                        "  ****  \n" +
////                        "circle r\n";
////
////        String rectangle =
////                        " +----+ \n" +
////                        " |    | \n" +
////                        " +----+ \n" +
////                        "rectangle a b\n";
////
////        //easy to add new shapes
////        return message + triangle + circle + rectangle;
////    }
//
//    public static String figuresListToString(List<Figure> figures){
//        StringToFigure stringToFigure = new StringToFigure();
//        StringBuilder stringBuilder = new StringBuilder();
//        for(Figure figure: figures){
//            stringBuilder.append(figure.toString()+"\n");
//        }
//        return stringBuilder.toString();
//    }
//
// welcome
//        //choose create method + provide input
//
//        List<Figure> figureList = new ArrayList<>();
//
//
//        System.out.println("\nWelcome to Figuro\n" +
//                "The app that helps you create geometrical shapes and calculate their parameters :)\n\n");
//        Scanner scanner = new Scanner(System.in);
//        String answer = scanner.nextLine();
//        if (answer.equalsIgnoreCase("create")) {
//
//            //CREATE--------------------------------------------------------------------------------------------------------//
//            //choose method
//            System.out.println("Choose a method for creating figures?\n" +
//                    ">random\n" +
//                    ">stdin\n" +
//                    ">file\n");
//
//            FigureFactory figureFactory = null;
//
//
//            if (answer.equalsIgnoreCase("random")) {
//                figureFactory = new RandomFigureFactory();
//
//            } else if (answer.equalsIgnoreCase("stdin")) {
//                System.out.print(instructionsForStdinInput());
//                answer = scanner.nextLine();
//                figureFactory = new StreamFigureFactory(new ByteArrayInputStream(answer.getBytes(StandardCharsets.UTF_8)));
//
//            } else if (answer.equalsIgnoreCase("file")) {
//                System.out.println("Provide the file location");
//                answer = scanner.nextLine();
//                Path source = null;
//                //maybe all of these should be in do while blocks or idk?
//                try {
//                    source = Paths.get(answer);
//                } catch (InvalidPathException e) {
//                    System.out.println("invalid path, input it again or exit:\n" + e.getMessage());
//                }
//
//                InputStream inputStream = null;
//
//                try {
//                    inputStream = Files.newInputStream(source);
//                } catch (IOException e) {
//                    System.out.println("something its wrong with this file:\n" + e.getMessage());
//                }
//                figureFactory = new StreamFigureFactory(inputStream);
//            }
//
//            figureList.add(figureFactory.create());
//        }
//
//        //DELETE----------------------------------------------------------------------------------------------------------------//
//        else if (answer.equalsIgnoreCase("delete")) {
//            System.out.println("Choose a figure you want to delete and write its String representation\n" +
//                    "here are all the current figures:");
//            String allFigures = figuresListToString(figureList);
//            System.out.println(allFigures);
//
//            answer = scanner.nextLine();
//            if(allFigures.contains(answer)){
//
//            }
//        }
//    }
//
//

//
//    public static boolean deleteFigureFromList(List<Figure> figures, String figureToBeDeleted){
//        StringToFigure stringToFigure = new StringToFigure();
//        for (Figure figure1: figures){
//            if(figure1.toString().equalsIgnoreCase(figureToBeDeleted.trim())){
//                int deleteID = figures.indexOf(figure1);
//                figures.remove(deleteID);
//                System.out.println(figureToBeDeleted + "is deleted!");
//                return true;
//            }
//        }
//        System.out.println(figureToBeDeleted + "is not found = not deleted!");
//        return false;
//    }
//
//
//}
///
//
}


