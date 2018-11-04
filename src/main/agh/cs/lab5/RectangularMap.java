package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;


public class RectangularMap extends AbstractWorldMap {

    private Position upperRight;
    private Position lowerLeft = new Position(0, 0);
    private List<Car> cars = new ArrayList<>();


    public RectangularMap(int width, int height) {
        upperRight = new Position(width - 1, height - 1);
    }


   /* @Override
    public boolean canMoveTo(Position position) {
        if(position.smaller(upperRight) && position.larger(lowerLeft) && !isOccupied(position))
            return true;
        return false;
    }

    @Override
    public boolean place(Car car) {
        if(!this.isOccupied(car.getPosition())){
            cars.add(car);
            return true;
        }
        else
            return false;
    }


    public void run1(MoveDirection[] directions, MapVisualizer mv) {

        for(int i = 0; i < directions.length; i++){
            cars.get(i%cars.size()).move(directions[i]);
            System.out.println(mv.draw(new Position(0,0),new Position(9,4)));
        }

    }
    @Override
    public void run(MoveDirection[] directions) {

        for(int i = 0; i < directions.length; i++){
            cars.get(i%cars.size()).move(directions[i]);
        }

    }

*/

    @Override
    public boolean isOccupied(Position position) {
        for(Car i: cars){
            if(i.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car i: cars){
            if(i.getPosition().equals(position))
                return i;
        }
        return null;
    }
}
