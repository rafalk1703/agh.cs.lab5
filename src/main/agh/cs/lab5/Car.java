package agh.cs.lab5;

public class Car {
    private Position position = new Position(2, 2);
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;

    //default constructor
    public Car() {
    }

    //optional constructors
    public Car(Position position, MapDirection orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Car(IWorldMap map) {
        this.map = map;
    }

    public Car(IWorldMap map, int x, int y) {
        this.map = map;
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        switch (orientation) {
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case WEST:
                return "W";
            case SOUTH:
                return "S";
            default:
                return "nic";
        }

    }



    public void move(MoveDirection direction) {
        if (direction == MoveDirection.LEFT)
            orientation = orientation.previous();

        else if (direction == MoveDirection.RIGHT)
            orientation = orientation.next();

        else {
            Position move1 = orientation.getPosition();

            if (direction == MoveDirection.FORWARD) {
                Position newPosition = position.add(move1);
                if (map.canMoveTo(newPosition))
                    position = newPosition;
            }
            else if (direction == MoveDirection.BACKWARD) {
                Position newPosition = position.substract(move1);
                if (map.canMoveTo(newPosition))
                    position = newPosition;
            }
        }
    }

}