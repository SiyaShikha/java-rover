import Rover.Rover;
import Rover.Movements;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("io/input.txt");
        Scanner scanner = new Scanner(inputFile);
        List<Rover> rovers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] position = scanner.nextLine().split(" ");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            String heading = position[2];

            String commands = scanner.nextLine();
            rovers.add(new Rover(x, y, heading, commands));
        }

        List<String> finalPositions = getFinalPositions(rovers);

        System.out.println("Final positions of the rovers:");
        finalPositions.forEach(System.out::println);

        scanner.close();
    }

    private static List<String> getFinalPositions(List<Rover> rovers) {
        return rovers.stream()
                .peek(Rover::execute)
                .map(Rover::toString)
                .collect(Collectors.toList());
    }
}