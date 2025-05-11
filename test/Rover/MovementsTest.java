package Rover;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class MovementsTest {
    @Test
    void move() throws Exception {
        Rover rover = new Rover(0, 0, "N","");
        assertEquals("W", Movements.L.move(rover));
        assertEquals("N", Movements.R.move(rover));
        assertEquals(Arrays.asList(0, 1), Movements.M.move(rover));
    }
}