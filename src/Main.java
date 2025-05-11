import Rover.Rover;
import Rover.Movements;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRovers = getNumberOfRovers(scanner);
        List<Rover> rovers = new ArrayList<>();
        getAllRovers(numberOfRovers, scanner, rovers);
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

    private static void getAllRovers(int numberOfRovers, Scanner scanner, List<Rover> rovers) {
        for (int i = 0; i < numberOfRovers; i++) {
            System.out.printf("Enter initial position and heading for rover %d (e.g., 1 2 N): ", i + 1);
            String[] position = scanner.nextLine().split(" ");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            String heading = position[2];

            System.out.printf("Enter command sequence for rover %d (e.g., LMLMLMLMM): ", i + 1);
            String commands = scanner.nextLine();

            rovers.add(new Rover(x, y, heading, commands));
        }
    }

    private static int getNumberOfRovers(Scanner scanner) {
        System.out.print("Enter the number of rovers: ");
        return Integer.parseInt(scanner.nextLine());
    }
}