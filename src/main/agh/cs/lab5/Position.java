package agh.cs.lab5;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "("+this.x+","+this.y+")";
    }
    public boolean smaller(Position pos){
        if(this.x <= pos.x && this.y <= pos.y)
            return true;
        return false;
    }
    public boolean larger(Position pos){
        if(this.x >= pos.x && this.y >= pos.y)
            return true;
        return false;
    }
    public Position upperRight(Position pos){
        if(pos == null)
            return this;

        int resX;
        int resY;
        if(pos.y >= this.y)
            resY = pos.y;
        else
            resY = this.y;
        if(pos.x >= this.x)
            resX = pos.x;
        else
            resX = this.x;
        return new Position(resX, resY);
    }
    public Position lowerLeft(Position pos){
        if(pos == null)
            return this;
        int resX;
        int resY;
        if(pos.y <= this.y)
            resY = pos.y;
        else
            resY = this.y;
        if(pos.x <= this.x)
            resX = pos.x;
        else
            resX = this.x;
        return new Position(resX, resY);
    }
    public Position add(Position pos){
        return new Position(pos.x+this.x, pos.y+this.y);
    }
    public Position substract(Position pos) {
        return new Position(this.x - pos.x, this.y - pos.y);
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Position))
            return false;
        Position that = (Position) o;

        if(this.x == that.x && this.y == that.y)
            return true;
        return false;
    }





}
