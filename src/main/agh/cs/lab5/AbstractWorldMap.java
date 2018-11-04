package agh.cs.lab5;


import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {

    List <Car> cars = new LinkedList<>();


    @Override
    public boolean canMoveTo(Position position) {
        if(!isOccupied(position))
            return true;
        return false;
    }

    @Override
    public boolean place(Car car) {
        if(!isOccupied(car.getPosition())){
            cars.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length; i++){
            cars.get(i%cars.size()).move(directions[i]);
        }
    }

    @Override
    public abstract boolean isOccupied(Position position);



    @Override
    public abstract Object objectAt(Position position);
}
