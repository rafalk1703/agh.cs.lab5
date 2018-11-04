package agh.cs.lab5;

import java.util.LinkedList;
import java.util.List;

public class CarSystem {
    public static void main(String[] args) {
        MoveDirection [] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        MapVisualizer mv = new MapVisualizer(map);

        Car car1 = new Car(map,2,2);
        Car car2 = new Car(map, 2,3);

        List<HayStack> list = new LinkedList<>();
        list.add(new HayStack(new Position(-4,-4)));
        list.add(new HayStack(new Position(7,7)));
        list.add(new HayStack(new Position(3,6)));
        list.add(new HayStack(new Position(2,0)));

        IWorldMap map1 = new UnboundedMap(list);
        map1.place(car1);
        map1.place(car2);
        MapVisualizer mv2 = new MapVisualizer(map1);
        ((UnboundedMap) map1).getUpperMax();

        System.out.println(mv2.draw(((UnboundedMap) map1).getMinPosition(),((UnboundedMap) map1).getMaxPosition()));

    }
}
