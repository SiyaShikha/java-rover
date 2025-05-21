package Rover;

import java.util.Arrays;
import java.util.List;

public class Rover {
    private int x;
    private int y;
    private String direction;
    private final String commands;

    private final List<String> acwDirections = Arrays.asList("N", "W", "S", "E");
    private final List<String> cwDirections = Arrays.asList("N", "E", "S", "W");

    public Rover(int x, int y, String direction, String commands) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.commands = commands;
    }

    public String turnLeft() {
        int index = acwDirections.indexOf(this.direction);

        this.direction = acwDirections.get((index + 1) % acwDirections.size());
        return this.direction;
    }

    public String turnRight() {
        int index = cwDirections.indexOf(this.direction);

        this.direction = cwDirections.get((index + 1) % cwDirections.size());
        return this.direction;
    }

    public List<Integer> moveForward() {
        switch (direction) {
            case "N":
                this.y++;
                break;
            case "E":
                this.x++;
                break;
            case "S":
                this.y--;
                break;
            case "W":
                this.x--;
                break;
        }

        return Arrays.asList(this.x, this.y);
    }

    public List<Object> execute() {
        for (char commandChar : this.commands.toCharArray()) {
            try {
                String command = String.valueOf(commandChar);
                Movements.valueOf(command).move(this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return Arrays.asList(this.x, this.y, this.direction);
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}

