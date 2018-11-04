package agh.cs.lab5;

import org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class UnboundedMapTest {



    @Test
    public void canMoveToTest(){
        List <Car> cars = new LinkedList<>();
        List <HayStack> stacks = new LinkedList<>();

        HayStack hs = new HayStack(new Position(-4,-4));
        stacks.add(hs);
        IWorldMap map = new UnboundedMap(stacks);
        Car car1 = new Car(map,2,2);
        Car car2 = new Car(map, 2,3);
        map.place(car1);
        map.place(car2);

        assertTrue(map.canMoveTo(new Position(2,4)));
        assertFalse(map.canMoveTo(car1.getPosition()));
        assertFalse(map.canMoveTo(hs.getPosition()));
    }

    @Test
    public void placeTest(){
        List <HayStack> stacks = new LinkedList<>();

        HayStack hs = new HayStack(new Position(-4,-4));
        stacks.add(hs);
        IWorldMap map = new UnboundedMap(stacks);
        Car car1 = new Car(map,2,2);
        Car car2 = new Car(map, 2,3);
        //same position as hs
        Car car3 = new Car(map,-4,-4);
        map.place(car1);
        map.place(car2);
        map.place(car3);
        assertTrue(map.isOccupied(car1.getPosition()));
        assertTrue(map.isOccupied(car2.getPosition()));
        assertEquals(hs,map.objectAt(new Position(-4,-4)));
        assertFalse(map.place(car3));

    }

    @Test
    public void isOccupiedTest(){
        List <Car> cars = new LinkedList<>();
        List <HayStack> stacks = new LinkedList<>();

        HayStack hs = new HayStack(new Position(-4,-4));
        stacks.add(hs);
        IWorldMap map = new UnboundedMap(stacks);
        Car car1 = new Car(map,2,2);
        Car car2 = new Car(map, 2,3);
        map.place(car1);
        map.place(car2);

        assertTrue(map.isOccupied(car1.getPosition()));
        assertFalse(map.isOccupied(new Position(100,0)));
        assertTrue(map.isOccupied(hs.getPosition()));
    }

    /*  @Test
   public void runTest(){
          MoveDirection [] dirs = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT,
                  MoveDirection.BACKWARD, MoveDirection.BACKWARD};

          IWorldMap map = new UnboundedMap(list);
          Car car1 = new Car();

      }*/

    @Test
    public void objectAtTest(){
        List <Car> cars = new LinkedList<>();
        List <HayStack> stacks = new LinkedList<>();



        HayStack hs = new HayStack(new Position(-4,-4));
        stacks.add(hs);
        stacks.add(new HayStack(new Position(7,7)));
        stacks.add(new HayStack(new Position(3,6)));
        stacks.add(new HayStack(new Position(2,0)));

        IWorldMap map = new UnboundedMap(stacks);

        Car car1 = new Car(map,2,2);
        Car car2 = new Car(map, 2,3);
        map.place(car1);
        map.place(car2);
        assertEquals(hs,map.objectAt(hs.getPosition()));
        assertEquals(null, map.objectAt(new Position(7,9)));
        assertEquals(car1,map.objectAt(car1.getPosition()));

    }

}
