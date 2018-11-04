package agh.cs.lab5;

import javax.print.attribute.HashAttributeSet;
import java.util.LinkedList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    private Position minPosition;
    private Position maxPosition;

    List <HayStack> stackList;
    List <Car> cars = new LinkedList<>();

    public UnboundedMap(List<HayStack> stackList) {
        this.stackList = stackList;
    }


    public Position getMinPosition() {
        return minPosition;
    }

    public Position getMaxPosition() {
        return maxPosition;
    }

    /*@Override
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
*/
    @Override
    public boolean isOccupied(Position position) {
        if(objectAt(position) == null)
            return false;
        return true;
    }

    @Override
    public Object objectAt(Position position) {
        Object result = null;
        for(HayStack s: stackList){
            if(s.getPosition().equals(position))
                result = s;
        }
        for(Car car: cars){
            if(car.getPosition().equals(position)){
                result = car;
            }
        }
        return result;
    }

    public void getUpperMax(){
        if(stackList != null){
            for (HayStack stack : stackList){
                minPosition = stack.getPosition().lowerLeft(minPosition);
                maxPosition = stack.getPosition().upperRight(maxPosition);
            }
        }
        if(cars != null){
            for(Car car : cars){
                minPosition = car.getPosition().lowerLeft(minPosition);
                maxPosition = car.getPosition().upperRight(maxPosition);
            }
        }
    }


}
