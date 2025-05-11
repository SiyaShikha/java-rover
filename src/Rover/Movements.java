package Rover;

public enum Movements {
    L, R, M;

    public Object move(Rover rover) throws Exception {
        switch (this) {
            case L:
                return rover.turnLeft();
            case R:
                return rover.turnRight();
            case M:
                return rover.moveForward();
            default:
                throw new Exception("Unknown movement: " + this);
        }
    }
}
