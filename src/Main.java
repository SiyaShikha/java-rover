import Rover.Rover;
import Rover.Movements;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Rover> rovers = new ArrayList<>();
        rovers.add(new Rover(1, 2, "N", "LMLMLMLMM"));
        rovers.add(new Rover(3, 3, "E", "MMRMMRMRRM"));
        rovers.add(new Rover(1, 2, "N", "LMLMLMLMM"));
        rovers.add(new Rover(3, 3, "E", "MMRMMRMRRM"));

        for (Rover rover : rovers) {
            rover.execute();

            String finalRoverPosition = rover.toString();
            System.out.println(finalRoverPosition);
        }
    }
}