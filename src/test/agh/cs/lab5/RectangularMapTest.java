package agh.cs.lab5;

import org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class RectangularMapTest {

    @Test
    public void canMoveToTest(){
        //I  assumed assume that map's width is: 5 and map's height is 10;
        // so corner points are: (0,0) and (4,9)
        RectangularMap map = new RectangularMap(5,10);
        assertTrue(map.canMoveTo(new Position(4,9)));
        assertFalse(map.canMoveTo(new Position(5,3)));
        assertFalse(map.canMoveTo(new Position(-1,0)));
    }

    @Test
    public void placeTest(){
        RectangularMap map = new RectangularMap(5,10);
        Car car1 = new Car(map,2,2);
        map.place(car1);

        //tested cars
        Car car2 = new Car(map,2,2);
        Car car3 = new Car(map,2,3);

        assertFalse(map.place(car2));
        assertTrue(map.place(car3));
    }

    @Test
    public void isOccupiedTest(){
        RectangularMap map = new RectangularMap(5,10);
        Car car1 = new Car(map,2,2);
        map.place(car1);

        assertTrue(map.isOccupied(car1.getPosition()));
        assertFalse(map.isOccupied(car1.getPosition().add(new Position(1,1))));
    }

    @Test
    public void runTest(){
        MoveDirection[] directions = {MoveDirection.FORWARD,MoveDirection.LEFT, MoveDirection.BACKWARD,MoveDirection.FORWARD,
                MoveDirection.LEFT,MoveDirection.BACKWARD,MoveDirection.FORWARD,MoveDirection.RIGHT};
        RectangularMap map = new RectangularMap(4,5);
        Car car1 = new Car(map,2,2);
        Car car2 = new Car(map,2,3);

        map.place(car1);
        map.place(car2);

        map.run(directions);

        assertEquals(new Position(1,1),car1.getPosition());
        assertEquals(new Position(2,3),car2.getPosition());
    }

    @Test
    public void objectAtTest(){
        RectangularMap map = new RectangularMap(4,5);
        Car car1 = new Car(map,2,2);
        Car car2 = new Car(map,2,3);

        map.place(car1);
        map.place(car2);
        assertEquals(null,map.objectAt(new Position(2,4)));
        assertEquals(car1,map.objectAt(car1.getPosition()));
        assertEquals(car2,map.objectAt(car2.getPosition()));
    }

}
