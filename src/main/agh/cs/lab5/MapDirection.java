package agh.cs.lab5;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){
        switch (this){
            case NORTH:
                return "Północ";

            case SOUTH:
                return "Południe";

            case EAST:
                return "Wschód";

            default:
                return "Zachód";
        }
    }

    public MapDirection next(){
        switch (this){
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            default:
                return NORTH;
        }
    }

    public MapDirection previous(){
        switch (this){
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            default:
                return SOUTH;
        }
    }

    public Position getPosition(){
        switch (this){
            case NORTH: return new Position(0,1);
            case SOUTH: return new Position(0,-1);
            case WEST: return new Position(-1,0);
            case EAST: return new Position(1,0);
            default: return new Position(0,0);

        }
    }

}