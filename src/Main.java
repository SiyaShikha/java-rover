import Rover.Rover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("io/input.txt");
        Scanner scanner = new Scanner(inputFile);
        PrintWriter writer = new PrintWriter("io/output.txt");
        List<Rover> rovers = new ArrayList<>();

        populateRoversFromFile(scanner, rovers);
        List<String> finalPositions = getFinalPositions(rovers);
        saveFinalPositionsToFile(writer, finalPositions);

        scanner.close();
        writer.close();

        System.out.println("Output is written to file output.txt");
    }

    private static void populateRoversFromFile(Scanner scanner, List<Rover> rovers) {
        while (scanner.hasNextLine()) {
            String[] position = scanner.nextLine().split(" ");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            String heading = position[2];

            String commands = scanner.nextLine();
            rovers.add(new Rover(x, y, heading, commands));
        }
    }

    private static void saveFinalPositionsToFile(PrintWriter writer, List<String> finalPositions) {
        writer.println("Final positions of the rovers:");
        for (String finalPosition : finalPositions) {
            writer.println(finalPosition);
        }
    }

    private static List<String> getFinalPositions(List<Rover> rovers) {
        return rovers.stream()
                .peek(Rover::execute)
                .map(Rover::toString)
                .collect(Collectors.toList());
    }
}