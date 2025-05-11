import Rover.Rover;
import Rover.Movements;

public class Main {
    public static void main(String[] args) {
        Rover rover = new Rover(3, 3, "E");
        String commandString = "MMRMMRMRRM";
        rover.execute(commandString);


        String finalRoverPosition = rover.toString();
        System.out.println(finalRoverPosition);
    }
}