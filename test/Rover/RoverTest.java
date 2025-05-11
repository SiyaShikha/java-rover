package Rover;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    @Test
    void turnLeft() {
        Rover rover = new Rover(0, 0, "N");

        assertEquals("W", rover.turnLeft());
        assertEquals("S", rover.turnLeft());
        assertEquals("E", rover.turnLeft());
        assertEquals("N", rover.turnLeft());
    }

    @Test
    void turnRight() {
        Rover rover = new Rover(0, 0, "N");

        assertEquals("E", rover.turnRight());
        assertEquals("S", rover.turnRight());
        assertEquals("W", rover.turnRight());
        assertEquals("N", rover.turnRight());
    }


    @Test
    void moveForward() {
        Rover rover = new Rover(0, 0, "N");
        assertEquals(Arrays.asList(0, 1), rover.moveForward());

        rover.turnRight();
        assertEquals(Arrays.asList(1, 1), rover.moveForward());
    }

    @Test
    void execute() {
        Rover rover = new Rover(0, 0, "N");

        assertEquals(Arrays.asList(0, 1, "N"), rover.execute("M"));
        assertEquals(Arrays.asList(0, 1, "E"), rover.execute("R"));
        assertEquals(Arrays.asList(0, 1, "N"), rover.execute("L"));
        assertEquals(Arrays.asList(1, 1, "E"), rover.execute("RM"));
    }

    @Test
    void testToString() {
        Rover rover = new Rover(0, 0, "N");
        assertEquals("0 0 N", rover.toString());
    }
}